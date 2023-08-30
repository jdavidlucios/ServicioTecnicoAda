package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Usuario;

import java.util.List;
public interface IUsuarioService {
    public Usuario crearUsuario(Usuario nuevoUsuario);
    public Usuario actualizarUsuario(int id);
    public List<Usuario> listarUsuario();
    public Usuario listarUsuarioID(int idUsuario);
    public void eliminarUsuario(int id);
}