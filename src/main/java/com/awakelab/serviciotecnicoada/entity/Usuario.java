package com.awakelab.serviciotecnicoada.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 75)
    private String nombreUsuario;

    @Column(name = "apellido1", length = 50)
    private String apellido1Usuario;

    @Column(name = "apellido2", length = 50)
    private String apellido2Usuario;

    @Column(nullable = false, length = 30)
    private String contraseñaUsuario;

    @Column(nullable = false, length = 35)
    private String rolUsuario;

    @OneToOne(mappedBy = "usuarioTecnico", cascade = CascadeType.ALL)
    private Tecnico tecnico;

    @OneToOne(mappedBy = "usuarioCliente", cascade = CascadeType.ALL)
    private Cliente cliente;
}
