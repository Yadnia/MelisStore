package org.Yaed.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class User {
    @Id
    @Column (name = "Email")
    private String userEmail;
    @Column (name = "Password")
    private String userPassword;
    @Column (name = "type")
    private String userType;

    public User() {
    }

    public User(String userEmail, String userPassword, String userType) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
