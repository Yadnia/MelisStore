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
    @Column (name = "prod Code")
    private String code;
    @Column (name = "categoria")
    private String cate;
    @Column (name = "prodSize")
    private String size;
    @Column (name = "prodStock")
    private int stock;

    public Producto() {
    }

    public Producto( String description, String color, String code, String cate, String size, int stock) {
        this.description = description;
        this.color = color;
        this.code = code;
        this.cate = cate;
        this.size = size;
        this.stock = stock;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
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
