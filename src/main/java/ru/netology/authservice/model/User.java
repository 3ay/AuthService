package ru.netology.authservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotBlank
    @Size(min = 8, max = 100)
    String password;
    @NotBlank
    @Size(min = 2, max = 100)
    String user;
}
