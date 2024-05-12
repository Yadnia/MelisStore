package org.Yaed.entity;

import jakarta.persistence.*;
import org.apache.commons.collections4.ArrayStack;

@Entity
@Table(name = "Administradores")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "adminId")
    private int idAdmin;
    @Column(name = "adNames")
    private String names;
    @Column (name = "adSurnames")
    private String Surnames;
    @Column (name = "adIDE")
    private String IDE;
    public Administrador(){

    }

    public Administrador(String names, String surnames, String IDE) {
        this.names = names;
        Surnames = surnames;
        this.IDE = IDE;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
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
                "idAdmin=" + idAdmin +
                ", names='" + names + '\'' +
                ", Surnames='" + Surnames + '\'' +
                ", IDE='" + IDE + '\'' +
                '}';
    }
}
