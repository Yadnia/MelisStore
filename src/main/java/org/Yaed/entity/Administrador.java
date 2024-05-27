package org.Yaed.entity;

import jakarta.persistence.*;
import org.apache.commons.collections4.ArrayStack;

@Entity
@DiscriminatorValue("Admin")
public class Administrador extends User{
    @Column(name = "Nombre Admin")
    private String names;
    @Column (name = "Apellido Admin")
    private String Surnames;
    @Column (name = "Cedula Admin")
    private String IDE;
    public Administrador(){

    }

    public Administrador(String userEmail, String userPassword, String names, String surnames, String IDE) {
        super(userEmail, userPassword);
        this.names = names;
        Surnames = surnames;
        this.IDE = IDE;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return Surnames;
    }

    public void setSurnames(String surnames) {
        Surnames = surnames;
    }

    public String getIDE() {
        return IDE;
    }

    public void setIDE(String IDE) {
        this.IDE = IDE;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                super.toString()+
                "names='" + names + '\'' +
                ", Surnames='" + Surnames + '\'' +
                ", IDE='" + IDE + '\'' +
                '}';
    }
}
