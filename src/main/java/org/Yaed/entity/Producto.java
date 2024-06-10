package org.Yaed.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int productId;

    @Column(name = "prod_desc")
    private String description;

    @Column(name = "prod_color")
    private String color;

    @Column(name = "prod_code")
    private String code;

    @Column(name = "categoria")
    private String cate;

    @Column(name = "prod_size")
    private String size;

    @Column(name = "prod_stock")
    private int stock;

    @Column(name = "precio")
    private int precio;

    // Default constructor
    public Producto() {
    }

    // Parameterized constructor
    public Producto(String description, String color, String code, String cate, String size, int stock, int precio) {
        this.description = description;
        this.color = color;
        this.code = code;
        this.cate = cate;
        this.size = size;
        this.stock = stock;
        this.precio = precio;
    }

    public Producto(String description) {
        this.description = description;
    }

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", code='" + code + '\'' +
                ", cate='" + cate + '\'' +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}
