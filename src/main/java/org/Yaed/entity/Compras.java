package org.Yaed.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

@Entity
@Table (name = "Ventas")
public class Compras {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

//    @Column (name = "Productos")
//    @ManyToMany (mappedBy = "productos")
//    private List <Producto> productos;
//    @Column (name = "Cliente")
//    private String Cliente;
//
//    @Column (name = "Vendedor")
//    @ManyToOne
//    @JoinColumn (name = "Vendedor")
//    private Vendedor vendedor;
//
//    @Column (name = "Monto")
//    private int monto;

}
