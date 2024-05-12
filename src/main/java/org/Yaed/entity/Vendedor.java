package org.Yaed.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table (name = "Vendedores")
public class Vendedor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "sellId")
    private int SellId;
    @Column (name = "sellName")
    private String names;
    @Column (name = "sellSurname")
    private String Surnames;
    @Column (name = "sellIDE")
    private String IDE;

    public Vendedor() {
    }

    public Vendedor(int sellId, String names, String surnames, String IDE) {
        SellId = sellId;
        this.names = names;
        Surnames = surnames;
        this.IDE = IDE;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "SellId=" + SellId +
                ", names='" + names + '\'' +
                ", Surnames='" + Surnames + '\'' +
                ", IDE='" + IDE + '\'' +
                '}';
    }
}
