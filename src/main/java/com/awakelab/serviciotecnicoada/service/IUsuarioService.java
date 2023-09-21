package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario nuevoUsuario);
    public Usuario actualizarUsuario(int id, Usuario usuario);
    public List<Usuario> listarUsuario();
    public Usuario listarUsuarioID(int id);
    public void eliminarUsuario(int id);

    void eliminarUsuario2(Usuario usuario);
}