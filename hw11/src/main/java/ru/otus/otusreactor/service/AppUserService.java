package ru.otus.otusreactor.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.otusreactor.model.AppUser;

public interface AppUserService {

    Flux<AppUser> getAll();

    Flux<String> getAllUsersNames();

    Flux<String> getAllUsersMails();

    Mono<AppUser> save(AppUser appUser);

}
