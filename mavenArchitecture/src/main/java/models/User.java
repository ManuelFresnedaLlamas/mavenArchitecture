package models;

import java.util.Date;
import java.util.UUID;

public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private Date createdAt;
    private String email;
    private String phone;
    private String language;
    private boolean disabled;
    private boolean initPass;

    public User(UUID id, String firstName, String lastName, Date createdAt, String email, String phone, String language, boolean disabled, boolean initPass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.email = email;
        this.phone = phone;
        this.language = language;
        this.disabled = false;
        this.initPass = true;
    }

    public User(String firstName, String lastName, Date createdAt, String email, String phone, String language, boolean disabled, boolean initPass) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = new Date();
        this.email = email;
        this.phone = phone;
        this.language = language;
        this.disabled = false;
        this.initPass = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isInitPass() {
        return initPass;
    }

    public void setInitPass(boolean initPass) {
        this.initPass = initPass;
    }
}
