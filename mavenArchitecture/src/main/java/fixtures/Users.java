package fixtures;

import appctr.Appctr;
import models.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Date;

public class Users {
    private Appctr appctr;
    private repositories.Users ru;
    private Logger log;
    public Users(Appctr appctr, repositories.Users ru) {
        this.appctr = appctr;
        this.ru = ru;
        this.log = appctr.logger;
    }

    public void createUserFixtures() throws SQLException {
        User u1 = new User("Manuel","Fresneda", new Date(),"mfresneda.dev@gmail.com","+34 675698388", "ES", false, false);
        ru.saveUser(u1);
    }
}
