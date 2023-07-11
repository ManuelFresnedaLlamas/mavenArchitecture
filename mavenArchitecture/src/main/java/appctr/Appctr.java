package appctr;

import org.apache.log4j.Logger;
import org.example.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class Appctr {
    public Logger logger;
    public Connection db;

    @Autowired
    private Environment env;
    public String envString;

    public Appctr() {
        this.logger = prepareLog();
        this.db = prepareDB();
        //this.envString = env.getProperty("ENV"); //TODO
        this.envString = "localhost";
    }

    public Logger prepareLog(){
        Logger logger = Logger.getLogger(Main.class);
        logger.info("Logger on!");
        return logger;
    }

    public Connection prepareDB(){
        String urlDB = "jdbc:postgresql://localhost:5432/mavenArchitecture";
        String username = "postgres";
        String password = "postgres";
        Connection connectionDB;
        try {
            connectionDB = DriverManager.getConnection(urlDB, username, password);
            this.logger.info("Conexión a la DB con éxito\n");
        } catch (SQLException e) {
            this.logger.info("Falló la conexión con la DB\n");
            throw new RuntimeException(e);
        }

        return connectionDB;
    }

}
