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
@Table(name = "Tecnicos")
public class Tecnico extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String emailTecnico;

    @Column(name = "telefono", length = 15)
    private String telefonoTecnico;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioTecnico;

    @OneToMany(mappedBy = "tecnico")
    private List<Producto> productos;

    public void setUsuario(Usuario usuario) {
    }
}