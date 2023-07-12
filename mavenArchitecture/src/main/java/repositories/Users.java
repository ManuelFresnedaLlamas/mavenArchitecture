package repositories;

import appctr.Appctr;
import models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {
    private Appctr appctr;
    private Connection db;

    private static String tableName = "users";
    public Users(Appctr appctr){
        this.appctr = appctr;
        this.db = appctr.db;
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(UUID.fromString(resultSet.getString("id")), resultSet.getString("firstName"),
                resultSet.getString("lastName"), resultSet.getDate("createdAt"),
                resultSet.getString("email"), resultSet.getString("phone"), resultSet.getString("language"),
                resultSet.getBoolean("disabled"), resultSet.getBoolean("initPass"));
    }
    public User getByID(@NotNull String id) throws SQLException {
        PreparedStatement statement = db.prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?");
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return createUserFromResultSet(resultSet);
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = db.prepareStatement("SELECT * FROM " + tableName);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = createUserFromResultSet(resultSet);
            userList.add(user);
        }

        return userList;
    }

    public void saveUser(User user) throws SQLException {
        if (user.getId() == null) {
            // Si el ID del usuario es nulo, significa que es un nuevo usuario y se debe realizar una inserción
            insertUser(user);
        } else {
            // Si el ID del usuario no es nulo, significa que ya existe en la base de datos y se debe realizar una actualización
            updateUser(user);
        }
    }

    private void insertUser(User user) throws SQLException {
        PreparedStatement statement = db.prepareStatement("INSERT INTO " + tableName + " (id, firstName, lastName, createdAt, email, phone, language, disabled, initPass) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, UUID.randomUUID().toString());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.setDate(4, new java.sql.Date(user.getCreatedAt().getTime()));
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getPhone());
        statement.setString(7, user.getLanguage());
        statement.setBoolean(8, user.isDisabled());
        statement.setBoolean(9, user.isInitPass());
        statement.executeUpdate();
    }

    private void updateUser(User user) throws SQLException {
        PreparedStatement statement = db.prepareStatement("UPDATE " + tableName + " SET firstName = ?, lastName = ?, createdAt = ?, email = ?, " +
                "phone = ?, language = ?, disabled = ?, initPass = ? WHERE id = ?");
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setDate(3, new java.sql.Date(user.getCreatedAt().getTime()));
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPhone());
        statement.setString(6, user.getLanguage());
        statement.setBoolean(7, user.isDisabled());
        statement.setBoolean(8, user.isInitPass());
        statement.setString(9, user.getId().toString());
        statement.executeUpdate();
    }

    public void deleteUser(UUID id) throws SQLException {
        PreparedStatement statement = db.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
        statement.setString(1, id.toString());
        statement.executeUpdate();
    }
}
