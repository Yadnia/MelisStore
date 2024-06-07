package org.Yaed.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "Ventas")
public class Ventas {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "Cliente")
    private String cliente;
    @Column  (name = "Productos")
    private String Productos;
    @Column (name = "Monto")
    private float Monto;
    @Column (name = "Vendedor")
    private String Vendedor;
    @Column (name = "Fecha")
    private Date fecha;

    public Ventas() {
    }

    public Ventas(String cliente, String productos, float monto, String vendedor, Date fecha) {
        this.cliente = cliente;
        Productos = productos;
        Monto = monto;
        Vendedor = vendedor;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", Productos='" + Productos + '\'' +
                ", Monto=" + Monto +
                ", Vendedor='" + Vendedor + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
