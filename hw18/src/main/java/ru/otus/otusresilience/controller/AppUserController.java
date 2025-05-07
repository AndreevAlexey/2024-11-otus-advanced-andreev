package ru.otus.otusresilience.controller;


import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.otusresilience.dto.AppUserDto;
import ru.otus.otusresilience.exception.AppException;
import ru.otus.otusresilience.model.AppUser;
import ru.otus.otusresilience.service.AppUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/user")
    public List<AppUserDto> getAll() {
        return
                appUserService.getAll()
                        .stream()
                        .map(AppUserDto::toDto)
                        .toList();
    }


    @GetMapping("/user/{id}")
    public AppUserDto getById(@PathVariable("id") long id) {
        AppUser user = appUserService.getById(id);
        return AppUserDto.toDto(user);
    }


    @PostMapping("/user")
    public AppUserDto add(@RequestBody AppUserDto appUserDto) {
        AppUser newUser = appUserService.save(appUserDto.toEntity());
        return AppUserDto.toDto(newUser);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        appUserService.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


    @GetMapping("/user/{id}/age")
    public int getAgeById(@PathVariable("id") long id) {
        return appUserService.getAgeById(id);
    }


    @ExceptionHandler
    public ResponseEntity<String> AppExceptionHandler(AppException exp) {
        return
                new ResponseEntity<>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({RequestNotPermitted.class})
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public void handleRequestNotPermitted() {
    }


    @ExceptionHandler({CallNotPermittedException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void handleCallNotPermittedException() {
    }

}
