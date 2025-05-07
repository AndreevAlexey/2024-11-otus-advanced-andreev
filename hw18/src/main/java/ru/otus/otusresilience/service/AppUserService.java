package ru.otus.otusresilience.service;

import ru.otus.otusresilience.model.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> getAll();

    AppUser save(AppUser appUser);

    void deleteById(long id);

    int getAgeById(long id);

    AppUser getById(long id);

}
