package org.Yaed.entity;

import jakarta.persistence.*;

import javax.crypto.Cipher;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ElementCollection
    @Column(name = "producto_id")
    private List<Long> productoIds;

    @Column(name = "monto")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @Column(name = "fecha")
    private LocalDate fecha;

    // Default constructor
    public Ventas() {
    }

    // Parameterized constructor
    public Ventas(Cliente cliente, List<Long> productoIds, float monto, Vendedor vendedor, LocalDate fecha) {
        this.cliente = cliente;
        this.productoIds = productoIds;
        this.monto = monto;
        this.vendedor = vendedor;
        this.fecha = fecha;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Long> getProductos() {
        return productoIds;
    }

    public void setProductos(List<Long> productos) {
        this.productoIds = productos;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", productos=" + productoIds +
                ", monto=" + monto +
                ", vendedor=" + vendedor +
                ", fecha=" + fecha +
                '}';
    }
}