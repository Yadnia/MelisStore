package org.Yaed.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@DiscriminatorValue("Vendedor")
public class Vendedor extends User{

    @Column (name = "Nombre Vendedor")
    private String names;
    @Column (name = "Apellido Vendedor")
    private String Surnames;
    @Column (name = "Cedula Vendedor")
    private String IDE;

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

    public Vendedor() {
    }

    public Vendedor(String userEmail, String userPassword, String names, String surnames, String IDE) {
        super(userEmail, userPassword);
        this.names = names;
        Surnames = surnames;
        this.IDE = IDE;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
              super.toString()+
                ", names='" + names + '\'' +
                ", Surnames='" + Surnames + '\'' +
                ", IDE='" + IDE + '\'' +
                '}';
    }
}
