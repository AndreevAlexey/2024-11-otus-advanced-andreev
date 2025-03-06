package ru.otus.demootusmemorydump.service;

import ru.otus.demootusmemorydump.model.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> getAll();

    AppUser insert(String username, String password);

    AppUser save(AppUser appUser);
}
