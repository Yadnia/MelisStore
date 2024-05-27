package org.Yaed.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table (name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "clID")
    private int ClientId;
    @Column(name = "clName")
    private String names;
    @Column (name = "clSurname")
    private String Surnames;
    @Column(name = "clIDE")
    private String IDE;

    public Cliente( String names, String surnames, String IDE) {
        this.names = names;
        Surnames = surnames;
        this.IDE = IDE;
    }

    public Cliente() {
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
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
        return "Cliente{" +
                "ClientId=" + ClientId +
                ", names='" + names + '\'' +
                ", Surnames='" + Surnames + '\'' +
                ", IDE='" + IDE + '\'' +
                '}';
    }
}
