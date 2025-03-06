package ru.otus.demootusmemorydump.service;


import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.demootusmemorydump.model.AppUser;
import ru.otus.demootusmemorydump.repository.AppUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    // Выбрал SHA-512, т.к. самый низкий % ошибок
    // Если выбирать по пропускной способности, то MD5
    private final DigestUtils alg = new DigestUtils("SHA-512");


    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }


    @Transactional
    public AppUser insert(String username, String password) {
        String hexPassword = getHex(password);
        AppUser newUser = new AppUser(0, username, hexPassword);
        newUser =  appUserRepository.save(newUser);
        return newUser;
    }


    private String getHex(String value) {
        return alg.digestAsHex(value);
    }


}
