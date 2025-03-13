package ru.otus.otusreactor.repository;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.otus.otusreactor.model.AppUser;


@Repository
public interface AppUserRepository extends ReactiveCrudRepository<AppUser, Long> {

    @Query(value = "select u.user_name from users u")
    Flux<String> getAllUsersNames();


    @Query(value = "select u.mail from users u where u.mail is not null")
    Flux<String> getAllUsersMails();


}
