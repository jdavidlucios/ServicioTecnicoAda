package com.awakelab.serviciotecnicoada.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombreProducto;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcionProducto;

    @Column(name = "estado", nullable = false, length = 50)
    private String estadoProducto;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnicoAsignado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clientePropietario;
}


