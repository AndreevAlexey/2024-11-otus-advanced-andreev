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

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CircuitBreakerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    AppUserRepository appUserRepository;


    @Test
    void test_circuit_breaker_limit() {
        var numberSuccessfulFirst = 5;
        var numberNotSuccessful = 10;
        var url = "/user/1";
        var appUser = Optional.of(new AppUser());

        Mockito.when(appUserRepository.findById(1L))
                .thenReturn(appUser, appUser, appUser, appUser, appUser)
                .thenThrow(IllegalStateException.class);

        var responses = new CopyOnWriteArrayList<ResponseEntity<String>>();

        IntStream.rangeClosed(1, numberSuccessfulFirst)
                .forEach(n -> responses.add(testRestTemplate.getForEntity(url, String.class)));

        IntStream.rangeClosed(1, numberNotSuccessful)
                .forEach(n -> responses.add(testRestTemplate.getForEntity(url, String.class)));

        assertEquals(numberSuccessfulFirst + numberNotSuccessful, responses.size());
        assertEquals(numberSuccessfulFirst,
                responses.stream().filter(it -> it.getStatusCode() == HttpStatus.OK).count());
        assertEquals(5,
                responses.stream().filter(it -> it.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR).count());
        assertEquals(5,
                responses.stream().filter(it -> it.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE).count());
    }

}
