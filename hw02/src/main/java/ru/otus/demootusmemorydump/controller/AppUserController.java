package ru.otus.demootusmemorydump.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.demootusmemorydump.model.AppUser;
import ru.otus.demootusmemorydump.service.AppUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/user")
    public List<AppUser> getAll() {
        return appUserService.getAll();
    }


    @PostMapping("/user")
    public AppUser add(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        return appUserService.insert(name, pass);
    }


    @GetMapping("/overload")
    public void overload() {
        appUserService.overload();
    }
}
