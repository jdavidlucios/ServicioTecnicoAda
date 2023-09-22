package com.awakelab.serviciotecnicoada.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
public class Cliente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String emailCliente;

    @Column(name = "telefono", length = 15)
    private String telefonoCliente;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCliente;

    public void setUsuario(Usuario usuario) {
    }
}