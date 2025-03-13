package ru.otus.otusreactor.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table(name = "users", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    private long id;

    @Column(value = "user_name")
    private String username;

    @Column(value = "user_pass")
    private String password;

    @Column(value = "mail")
    private String mail;


}
