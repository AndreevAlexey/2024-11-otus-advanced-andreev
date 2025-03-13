package ru.otus.demootusmemorydump.service;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.demootusmemorydump.model.AppUser;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional(propagation = Propagation.NEVER)
@DataJpaTest
@Import(AppUserServiceImpl.class)
public class AppUserServiceTest {

    @Autowired
    AppUserServiceImpl appUserService;

    @Autowired
    EntityManager em;

    @Test
    void shouldSaveNewUser() {
        // given
        var username = "new_user";
        var password = "new_pass";
        // when
        var returnedUser = appUserService.insert(username, password);
        // then
        assertThat(returnedUser).isNotNull()
                .matches(user -> user.getUsername().equals(username))
                .matches(user -> user.getPassword().equals(password));

        assertThat(em.find(AppUser.class, returnedUser.getId()))
                .isNotNull();
    }
}
