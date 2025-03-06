package ru.otus.demootusmemorydump.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.demootusmemorydump.exception.AppException;
import ru.otus.demootusmemorydump.model.AppUser;
import ru.otus.demootusmemorydump.service.AppUserService;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/user/count")
    public int getAllCount() {
        return appUserService.getAll().size();
    }


    @GetMapping("/user")
    public List<AppUser> getAll() {
        return appUserService.getAll();
    }


    @PostMapping("/user")
    public AppUser add(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        return appUserService.insert(name, pass);
    }


    @PostMapping(value = "/add")
    public AppUser add(@RequestBody AppUser appUser) {
        return appUserService.save(appUser);
    }


    @ExceptionHandler
    public ResponseEntity<String> AppExceptionHandler(AppException exp) {
        return
                new ResponseEntity<>("Error user registration!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
