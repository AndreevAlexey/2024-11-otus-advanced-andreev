package ru.otus.swagger.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import ru.otus.swagger.model.AppUser;


@Schema(description = "AppUser Dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {

    @Schema(description = "id")
    private long id;

    @Schema(description = "user name")
    private String username;

    @Schema(description = "user password")
    private String password;


    public static AppUserDto toDto(AppUser appUser) {
        return
                (appUser instanceof HibernateProxy)
                        ? new AppUserDto()
                        : new AppUserDto(appUser.getId(), appUser.getUsername(), appUser.getPassword());
    }


    public AppUser toEntity() {
        return new AppUser(this.id, this.username, this.password);
    }
}
