package ru.otus.otusresilience.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.otusresilience.exception.AppException;
import ru.otus.otusresilience.model.AppUser;
import ru.otus.otusresilience.repository.AppUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    private final ApiService apiService;


    @Override
    @Transactional(readOnly = true)
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    @CircuitBreaker(name = "rate_50_10s")
    public AppUser getById(long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found"));
    }


    @Override
    @Transactional
    public AppUser save(AppUser item) {
        return appUserRepository.save(item);
    }


    @Override
    @Transactional(readOnly = true)
    @RateLimiter(name = "rps_20")
    public int getAgeById(long id) {
        return apiService.getAgeById(id);
    }


    @Override
    @Transactional
    public void deleteById(long id) {
        appUserRepository.deleteById(id);
    }
}
