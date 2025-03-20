package ru.otus.graalvm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.graalvm.model.AppUser;


public class AppUserTest {

    @Test
    public void test() {
        // given
        String username = "test";
        AppUser appUser = new AppUser(1, username, "pass");
        // when
        String result = appUser.getUsername();
        // then
        Assertions.assertEquals(result, username);
    }
}
