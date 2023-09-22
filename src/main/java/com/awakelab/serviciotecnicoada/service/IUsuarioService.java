package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUsuarioService {

    @Transactional
    void crearUsuario(String nombreUsuario, String apellido1Usuario, String apellido2Usuario,
                      String contrasenaUsuario, String rolUsuario, String emailCliente, String telefonoCliente,
                      String emailTecnico, String telefonoTecnico);

    public Usuario actualizarUsuario(int id, Usuario usuario);
    public List<Usuario> listarUsuario();
    public Usuario listarUsuarioID(int id);
    public void eliminarUsuario(int id);

    void eliminarUsuario2(Usuario usuario);

}