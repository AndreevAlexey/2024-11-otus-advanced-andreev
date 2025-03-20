package ru.otus.graalvm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.graalvm.model.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
