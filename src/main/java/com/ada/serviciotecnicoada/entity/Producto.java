package com.ada.serviciotecnicoada.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String codigo_producto;

    @Column(length = 100)
    private String nombre_producto;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaProductos")
    private List<Tecnico> listaTecnicos;

    @JsonIgnore
    @OneToMany(mappedBy = "miProducto")
    private List<Cliente> listaClientes;
}
