package ru.otus.otusreactor.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.otusreactor.exception.AppException;
import ru.otus.otusreactor.model.AppUser;
import ru.otus.otusreactor.repository.AppUserRepository;


@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    private final DigestUtils hexer = new DigestUtils("SHA-512");


    @Override
    public Flux<AppUser> getAll() {
        return appUserRepository.findAll();
    }


    @Override
    public Mono<AppUser> save(AppUser item) {
        try {
            String hexPassword = getHex(item.getPassword());
            item.setPassword(hexPassword);
            return appUserRepository.save(item);
        } catch (Exception exp) {
            log.error(exp.getMessage());
            throw new AppException(exp.getMessage());
        }
    }


    @Override
    public Flux<String> getAllUsersNames() {
        return appUserRepository.getAllUsersNames();
    }


    @Override
    public Flux<String> getAllUsersMails() {
        return appUserRepository.getAllUsersMails();
    }


    private synchronized String getHex(String value) {
        return hexer.digestAsHex(value);
    }

}
