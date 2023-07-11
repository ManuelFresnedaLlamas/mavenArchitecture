package models;

import java.util.UUID;

public class Auth {
    private UUID id;
    private String login;
    private String passwordHash;
    private String passwordSalt;
    private String passwordResetToken;
    private int role;
    private UUID userID;

    public Auth(String login, String passwordHash, String passwordSalt, String passwordResetToken, int role, UUID userID) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.passwordResetToken = passwordResetToken;
        this.role = role;
        this.userID = userID;
    }

    public Auth(UUID id, String login, int role, UUID userID) {
        this.id = id;
        this.login = login;
        this.passwordHash = "";
        this.passwordSalt = "";
        this.passwordResetToken = "";
        this.role = role;
        this.userID = userID;
    }
}
