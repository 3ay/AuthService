package ru.netology.authservice.repository;


import org.springframework.stereotype.Repository;
import ru.netology.authservice.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final String USER_NAME = "freshdev";
    private final String PASSWORD = "90$He_Y78";

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (USER_NAME.equals(user) && PASSWORD.equals(password)) {
            List<Authorities> result = new ArrayList<>();
            result.add(Authorities.READ);
            result.add(Authorities.WRITE);
            return result;
        } else
            return new ArrayList<>();
    }
}
