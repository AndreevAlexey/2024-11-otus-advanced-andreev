package ru.otus.otusreactor.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.otusreactor.exception.AppException;
import ru.otus.otusreactor.model.AppUser;
import ru.otus.otusreactor.service.AppUserService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/user")
    public Flux<AppUser> getAll() {
        return appUserService.getAll();
    }


    @PostMapping(value = "/user")
    public Mono<AppUser> add(@RequestBody AppUser appUser) {
        return appUserService.save(appUser);
    }


    @GetMapping("/user/names")
    public Mono<List<String>> getAllUserNames() {
        return appUserService.getAllUsersNames().collectList();
    }


    @GetMapping("/user/mails")
    public Mono<List<String>> getAllUserMails() {
        return appUserService.getAllUsersMails().collectList();
    }


    @ExceptionHandler
    public ResponseEntity<String> AppExceptionHandler(AppException exp) {
        return
                new ResponseEntity<>("Error user registration!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
