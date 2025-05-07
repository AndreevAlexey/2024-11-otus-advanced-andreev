package ru.otus.otusresilience.resilence4j;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.otus.otusresilience.model.AppUser;
import ru.otus.otusresilience.repository.AppUserRepository;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RateLimiterRpmTest {

    private static final HttpStatus OK = HttpStatus.OK;

    private static final HttpStatus ERROR = HttpStatus.TOO_MANY_REQUESTS;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    AppUserRepository appUserRepository;

    @Test
    void test_rpm_20_limit() {
        var limitRps = 20;
        var limitRpm = 30;
        var repeat = 3;
        var url = "/user/1/age";
        var user = new AppUser();

        user.setAge(25);

        Mockito.when(appUserRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        var responses = new CopyOnWriteArrayList<ResponseEntity<String>>();

        IntStream.rangeClosed(1, repeat).forEach(i -> {
            IntStream.rangeClosed(1, limitRps)
                    .parallel()
                    .forEach(n -> responses.add(testRestTemplate.getForEntity(url, String.class)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        assertEquals(limitRps * repeat, responses.size());
        assertEquals(limitRpm,
                responses.stream().filter(it -> it.getStatusCode() == OK).count());
        assertEquals(limitRps * repeat - limitRpm,
                responses.stream().filter(it -> it.getStatusCode() == ERROR).count());
    }

}
