package ru.otus.demootusmemorydump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.demootusmemorydump.model.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
