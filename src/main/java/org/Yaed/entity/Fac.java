package org.Yaed.entity;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table (name = "Facturas")
public class Fac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facId")
    private int FacId;
    @Column(name = "prodId")
    private int prodId;
    @Column(name = "sellId")
    private int sellId;

    public int getFacId() {
        return FacId;
    }

    public void setFacId(int facId) {
        FacId = facId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public Fac() {
    }

    public Fac(int prodId, int sellId) {
        this.prodId = prodId;
        this.sellId = sellId;
    }

    @Override
    public String toString() {
        return "Fac{" +
                "FacId=" + FacId +
                ", prodId=" + prodId +
                ", sellId=" + sellId +
                '}';
    }
}
