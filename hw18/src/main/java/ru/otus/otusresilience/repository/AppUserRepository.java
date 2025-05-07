package ru.otus.otusresilience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.otusresilience.model.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
