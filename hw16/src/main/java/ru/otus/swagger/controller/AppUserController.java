package ru.otus.swagger.controller;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.swagger.dto.AppUserDto;
import ru.otus.swagger.exception.AppException;
import ru.otus.swagger.model.AppUser;
import ru.otus.swagger.service.AppUserService;

import java.util.List;


@Tag(
        name = "User API",
        description = "Api for users registration"
)
@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;


    @GetMapping("/user")
    public List<AppUserDto> getAll() {
        return
                appUserService.getAll()
                        .stream()
                        .map(AppUserDto::toDto)
                        .toList();
    }


    @PostMapping("/user")
    public AppUser add(@RequestBody AppUserDto appUserDto) {
        return appUserService.save(appUserDto.toEntity());
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(
            @Parameter(required = true, description = "ID of user fro delete") @PathVariable("id") long id) {
        appUserService.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


    @ExceptionHandler
    public ResponseEntity<String> AppExceptionHandler(AppException exp) {
        return
                new ResponseEntity<>("Error user registration!%s".formatted(exp.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
