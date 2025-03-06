package ru.otus.demootusmemorydump.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.demootusmemorydump.model.AppUser;
import ru.otus.demootusmemorydump.repository.AppUserRepository;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private static final long CNT = 100_000L;

    private final AppUserRepository appUserRepository;

    private static final Map<String, String> userMap = new HashMap<>();


    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Transactional
    public AppUser insert(String username, String password) {
        AppUser newUser = new AppUser(0, username, password);
        newUser =  appUserRepository.save(newUser);
        userMap.put(username, password);
        return newUser;
    }


    public void overload() {
        for (int i = 1; i <= CNT; i++) {
            insert("user" + i, "pass" + i);
            if (i%1000 == 0) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
