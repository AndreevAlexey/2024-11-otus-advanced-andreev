package ru.otus.otusresilience.resilence4j;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.otus.otusresilience.service.ApiService;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RateLimiterRpsTest {

    private static final HttpStatus OK = HttpStatus.OK;

    private static final HttpStatus ERROR = HttpStatus.TOO_MANY_REQUESTS;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    ApiService apiService;


    @Test
    void test_rps_20_limit() {
        var limit = 20;
        var countRequest = limit + 5;
        var url = "/user/1/age";

        Mockito.when(apiService.getAgeById(1)).thenReturn(25);

        var responses = new CopyOnWriteArrayList<ResponseEntity<String>>();

        IntStream.rangeClosed(1, countRequest)
                .parallel()
                .forEach(n -> responses.add(testRestTemplate.getForEntity(url, String.class)));

        assertEquals(countRequest, responses.size());
        assertEquals(limit,
                responses.stream().filter(it -> it.getStatusCode() == OK).count());
        assertEquals(limit,
                countRequest - responses.stream().filter(it -> it.getStatusCode() == ERROR).count());
    }

}
