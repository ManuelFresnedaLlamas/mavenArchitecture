package org.example;

import appctr.Appctr;
import enums.Env;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Appctr appctr = new Appctr();
        if (appctr.envString == Env.TEST.toString()) {
            //TODO realizar migraciones
            //TODO realizar fixtures
        } else if (appctr.envString == Env.PROD.toString()) {
            //TODO realizar migracionesProduccion
        }

    }
}