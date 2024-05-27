package org.Yaed.entity;

import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "Tipo")
@Table(name = "Usuarios")
public class User {
    @Id
    @Column (name = "Email")
    private String userEmail;
    @Column (name = "Password")
    private String userPassword;

    public User() {
    }

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
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


    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +

                '}';
    }
}
