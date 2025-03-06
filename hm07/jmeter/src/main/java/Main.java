import org.apache.http.entity.ContentType;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;
import org.apache.logging.log4j.util.Strings;
import us.abstracta.jmeter.javadsl.core.DslTestPlan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;


public class Main {

    private static final int THREADS = 100;

    private static final int ITERATIONS = 10;

    private static final int RAMP = 1;

    private static final int PORT = 8080;

    private static final String HOST = "localhost";

    private static final String PATH = "/user";

    private static final String METHOD = "POST";

    private static final String URL = "http://localhost:8080/add";

    private static final String BODY = "{\"id\": 0, \"username\": \"${__UUID}\", \"password\": \"${__UUID}\"}";

    private static final String DSL_LOGS = "dsl-pt-logs.jtl";

    private static final String DSL_DIR = "./jmeter";

    private static final String LOGS = "./jmeter/pt-logs.jtl";

    private static final String SCRIPT = "./jmeter/script.jmx";


    public static void main(String[] args) throws IOException {
        getDslTestPlan().run();

        getStandardJMeterEngine().run();
    }

    private static DslTestPlan getDslTestPlan() {
        return
                testPlan(
                        threadGroup(
                                THREADS,
                                ITERATIONS,
                                httpSampler(URL)
                                        .post(BODY, ContentType.APPLICATION_JSON))
                        ,jtlWriter(DSL_DIR, DSL_LOGS));
    }

    private static StandardJMeterEngine getStandardJMeterEngine() throws IOException {
        String jmeterHome = System.getenv("JMETER_HOME");

        if (jmeterHome == null) {
            throw new RuntimeException("JMETER_HOME environment variable is not set.");
        }

        JMeterUtils.loadJMeterProperties(Strings.concat(jmeterHome, "\\bin\\jmeter.properties"));
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.initLocale();

        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        ThreadGroup threadGroup = getThreadGroup();

        TestPlan testPlan = getTestPlan(threadGroup);

        ListedHashTree testPlanTree = new ListedHashTree();

        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);
        String name = "${__UUID}";
        String pass = "${__UUID}";
        HTTPSamplerProxy sampler = getHttpSamplerProxy(name, pass);
        threadGroupHashTree.add(sampler);

        SaveService.saveTree(testPlanTree, Files.newOutputStream(Paths.get(SCRIPT)));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (!summariserName.isEmpty()) {
            summer = new Summariser(summariserName);
        }
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(LOGS);
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        jmeter.configure(testPlanTree);
        return jmeter;
    }

    private static ThreadGroup getThreadGroup() {

        LoopController loopController = new LoopController();
        loopController.setLoops(ITERATIONS);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Register Service");
        threadGroup.setNumThreads(THREADS);
        threadGroup.setRampUp(RAMP);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
        return threadGroup;
    }

    private static TestPlan getTestPlan(ThreadGroup threadGroup) {
        TestPlan testPlan = new TestPlan("Register Service Test Plan");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.addThreadGroup(threadGroup);
        return testPlan;
    }

    private static HTTPSamplerProxy getHttpSamplerProxy(String name, String pass) {
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        httpSampler.setDomain(HOST);
        httpSampler.setPort(PORT);
        httpSampler.setPath(PATH);
        httpSampler.addNonEncodedArgument("name", name, "");
        httpSampler.addNonEncodedArgument("pass", pass, "");
        httpSampler.setMethod(METHOD);
        httpSampler.setName("API");
        httpSampler.setDoMultipart(false);
        httpSampler.setDoBrowserCompatibleMultipart(true);
        httpSampler.setName("register");
        return httpSampler;
    }

}
