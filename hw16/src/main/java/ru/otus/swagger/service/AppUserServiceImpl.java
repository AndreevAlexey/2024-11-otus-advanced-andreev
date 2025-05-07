package ru.otus.swagger.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.swagger.exception.AppException;
import ru.otus.swagger.model.AppUser;
import ru.otus.swagger.repository.AppUserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {


    private final AppUserRepository appUserRepository;

    private final DigestUtils hexer = new DigestUtils("MD5");


    @Transactional(readOnly = true)
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }


    @Transactional
    public AppUser save(AppUser item) {
        try {
            String hexPassword = getHex(item.getPassword());
            item.setPassword(hexPassword);

            AppUser newUser = appUserRepository.save(item);
            log.info("Registered user = %s".formatted(newUser.getUsername()));

            return newUser;
        } catch (Exception exp) {
            log.error(exp.getMessage());
            throw new AppException(exp.getMessage());
        }
    }


    @Transactional
    public void deleteById(long id) {
        appUserRepository.deleteById(id);
    }


    private synchronized String getHex(String value) {
        return hexer.digestAsHex(value);
    }

}
