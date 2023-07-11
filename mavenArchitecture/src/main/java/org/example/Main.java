package org.example;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class);

        System.out.printf("Launching App!\n");
        String urlDB = "jdbc:postgresql://localhost:5432/mavenArchitecture";
        String username = "postgres";
        String password = "postgres";

        try {
            Connection connectionDB = DriverManager.getConnection(urlDB, username, password);
            logger.info("Conexión a la DB con éxito\n");
        } catch (SQLException e) {
            logger.info("Falló la conexión con la DB\n");
            throw new RuntimeException(e);
        }
    }
}