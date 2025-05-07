package ru.otus.swagger.service;

import ru.otus.swagger.model.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> getAll();

    AppUser save(AppUser appUser);

    void deleteById(long id);

}
