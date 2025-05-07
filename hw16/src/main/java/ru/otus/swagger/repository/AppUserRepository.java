package ru.otus.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.swagger.model.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
