package com.ada.serviciotecnicoada.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tecnicos")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(nullable = false, length = 72)
    private String nombres;

    @Column(length = 30)
    private String apellido1;

    @Column(length = 30)
    private String apellido2;

    @ManyToMany
    @JoinTable(name = "Tecnico_Producto",
            joinColumns = @JoinColumn(name = "Fk_Tecnico", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_Producto", nullable = false))
    private List<Producto> listaProductos;
}
