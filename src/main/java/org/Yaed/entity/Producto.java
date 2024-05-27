package org.Yaed.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ProdId")
    private int ProductId;
    @Column (name = "prodDesc")
    private String description;
    @Column (name = "prodColor")
    private String color;
    @Column (name = "prodSize")
    private String size;
    @Column (name = "prodStock")
    private int stock;

    public Producto() {
    }

    public Producto(int productId, String description,  String color, String size, int stock) {
        ProductId = productId;
        this.description = description;
        this.color = color;
        this.size = size;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "ProductId=" + ProductId +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                '}';
    }
}
