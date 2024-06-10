package org.Yaed.entity;

import jakarta.persistence.*;

import javax.crypto.Cipher;
import java.time.LocalDateTime;
import java.util.Date;
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

    @ManyToMany
    @JoinTable(
            name = "Ventas_Productos",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productos;

    @Column(name = "monto")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    // Default constructor
    public Ventas() {
    }

    // Parameterized constructor
    public Ventas(Cliente cliente, Set<Producto> productos, float monto, Vendedor vendedor, LocalDateTime fecha) {
        this.cliente = cliente;
        this.productos = productos;
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

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", monto=" + monto +
                ", vendedor=" + vendedor +
                ", fecha=" + fecha +
                '}';
    }
}