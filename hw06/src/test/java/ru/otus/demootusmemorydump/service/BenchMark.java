package ru.otus.demootusmemorydump.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BenchMark {

    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        @Param({"SHA-256", "SHA-512", "MD5"})
        public String alg;

        public Map<String, DigestUtils> algMap;

        public DigestUtils sha256;

        public String password = "4v3rys3kur3p455w0rd";

        @Setup(Level.Invocation)
        public void setUp() {
            algMap = new HashMap<>();
            algMap.put("SHA-256", new DigestUtils("SHA-256"));
            algMap.put("SHA-512", new DigestUtils("SHA-512"));
            algMap.put("MD5", new DigestUtils("MD5"));
            sha256 = new DigestUtils("SHA-256");
        }
    }


    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.All)
    @Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5)
    public void benchHashAlg(ExecutionPlan plan, Blackhole bh) {
        bh.consume(plan.algMap.get(plan.alg).digestAsHex(plan.password));
    }

}
