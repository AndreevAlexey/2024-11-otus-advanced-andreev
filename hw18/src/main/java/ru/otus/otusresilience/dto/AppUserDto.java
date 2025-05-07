package ru.otus.otusresilience.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import ru.otus.otusresilience.model.AppUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {

    private long id;

    private String username;

    private String password;

    private String mail;

    private int age;


    public static AppUserDto toDto(AppUser appUser) {
        return
                (appUser instanceof HibernateProxy)
                        ? new AppUserDto()
                        : new AppUserDto(
                                appUser.getId(),
                                appUser.getUsername(),
                                appUser.getPassword(),
                                appUser.getMail(),
                                appUser.getAge());
    }


    public AppUser toEntity() {
        return new AppUser(id, username, password, mail, age);
    }
}

