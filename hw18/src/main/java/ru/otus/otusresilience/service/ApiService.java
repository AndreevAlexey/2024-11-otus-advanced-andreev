package ru.otus.otusresilience.service;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.otusresilience.exception.AppException;
import ru.otus.otusresilience.repository.AppUserRepository;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final AppUserRepository appUserRepository;


    @Transactional(readOnly = true)
    @RateLimiter(name = "rpm_30")
    public int getAgeById(long id) {
        return
                appUserRepository.findById(id)
                        .orElseThrow(() -> new AppException("User not found"))
                        .getAge();
    }
}
