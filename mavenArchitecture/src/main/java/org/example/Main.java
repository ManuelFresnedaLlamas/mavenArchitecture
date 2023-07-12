package org.example;

import appctr.Appctr;
import enums.Env;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        SpringApplication.run(Main.class, args);
        Appctr appctr = new Appctr();
        if (appctr.envString == Env.localhost.toString()) {
            System.out.println(System.getProperty("user.dir"));
            doMigrations(appctr);
            doFixtures(appctr);
            //TODO realizar fixtures
        } else if (appctr.envString == Env.PROD.toString()) {
            /*
            Lo suyo seria un script que detecte cambios en las tablas y aplique las modificaciones

            O mas sencillo, una carpeta llamado "prod" en migrations que contenga los cambios
            en las tablas, por ejemplo, añadir una columna a una tabla sera:
            "ALTER TABLE ADD COLUMN nombre_columna tipo_dato constraintSiTiene"
            y que se ejecuten estos. Una vez hecho esto, actualizar los .sql de /migrations
            y estos de /migrations/prod/ renombrarlos a nombreFichero.sql.old => asi aseguramos que no se
            vuelve a ejecutar y mantenemos historial de cambios (si se usa git, se pueden borrar y queda historial en git)
            */
        }

    }


    public static void doMigrations(Appctr appctr) throws IOException, SQLException {
        String readTable = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/migrations/create_users_table.sql")));
        Statement statement = appctr.db.createStatement();
        Boolean var = statement.execute(readTable);
        System.out.println(var);
        /*
        if (var){
            appctr.logger.info("Tabla creada con éxito");
        } else {
            appctr.logger.info("Tabla NO CREADA");
        }*/
        statement.close();
    }

    public static void doFixtures(Appctr appctr) {

    }
}