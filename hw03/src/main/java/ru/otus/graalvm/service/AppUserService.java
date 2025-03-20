package ru.otus.graalvm.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.graalvm.model.AppUser;
import ru.otus.graalvm.repository.AppUserRepository;

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
        userMap.put(username, password);
        AppUser newUser = new AppUser(0, username, password);
        newUser =  appUserRepository.save(newUser);
//        userMap.remove(username);
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
