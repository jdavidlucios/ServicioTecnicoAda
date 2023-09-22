package com.awakelab.serviciotecnicoada.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 75)
    private String nombreCliente;

    @Column(name = "apellido1", length = 50)
    private String apellido1Cliente;

    @Column(name = "apellido2", length = 50)
    private String apellido2Cliente;

    @Column(nullable = false, length = 30)
    private String contrasenaCliente;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String emailCliente;

    @Column(name = "telefono", length = 15)
    private String telefonoCliente;

    @OneToMany(mappedBy = "clientePropietario")
    private List<Producto> productosCliente;
}