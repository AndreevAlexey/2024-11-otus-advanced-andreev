package ru.otus.demootusmemorydump.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.demootusmemorydump.exception.AppException;
import ru.otus.demootusmemorydump.model.AppUser;
import ru.otus.demootusmemorydump.repository.AppUserRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.locks.Lock;


@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {


    private final AppUserRepository appUserRepository;

    private final DigestUtils hexer = new DigestUtils("SHA-512");


    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }


    @Transactional
    public AppUser insert(String username, String password) {
        try {
            String hexPassword = getHex(password);

            AppUser newUser = new AppUser(0, username, hexPassword);

            newUser = appUserRepository.save(newUser);

            log.info("Registered user = %s".formatted(username));
            return newUser;

        } catch (Exception exp) {
            log.error(exp.getMessage());
            throw new AppException(exp.getMessage());
        }
    }


    @Transactional
    public AppUser save(AppUser item) {
        try {
            String hexPassword = getHex(item.getPassword());
            item.setPassword(hexPassword);

            AppUser newUser = appUserRepository.save(item);
            log.info("Registered user = %s".formatted(newUser.getUsername()));

            appUserRepository.findAll();

            return newUser;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            throw new AppException(exp.getMessage());
        }
    }


    private synchronized String getHex(String value) {
        return hexer.digestAsHex(value);
    }

}
