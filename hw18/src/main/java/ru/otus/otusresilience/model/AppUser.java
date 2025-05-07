package ru.otus.otusresilience.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "app_users", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_pass")
    private String password;

    @Column(name = "mail")
    private String mail;

    @Column(name = "age")
    private int age;

}