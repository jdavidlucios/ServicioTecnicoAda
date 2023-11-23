package com.ada.serviciotecnicoada.service;

import com.ada.serviciotecnicoada.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();

    Usuario crearUsuario(Usuario crearUsuario);

    Usuario actualizarUsuario(int id, Usuario usuarioActualizado);

    void eliminarUsuario(int usuario);

    Usuario listarUsuarioId(int id);
}
