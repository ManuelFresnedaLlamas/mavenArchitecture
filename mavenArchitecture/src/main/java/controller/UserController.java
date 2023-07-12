package controller;

import appctr.Appctr;
import models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.Users;

import java.sql.SQLException;

@RestController
public class UserController {

    private Users ru =new Users(new Appctr());
    @GetMapping(value = "/api/user")
    public User getByID() throws SQLException {
        //Imaginemos que cogemos el JSON el id = af33ce46-4a41-497f-8b3c-163e6f963e1d
        String id = "af33ce46-4a41-497f-8b3c-163e6f963e1d";
        User u = ru.getByID(id);
        return u;
    }
}
