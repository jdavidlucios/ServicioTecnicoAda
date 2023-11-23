package com.ada.serviciotecnicoada.service.serviceImpl;

import com.ada.serviciotecnicoada.entity.Usuario;
import com.ada.serviciotecnicoada.repository.IUsuarioRepository;
import com.ada.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service ("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listarUsuario = new ArrayList<>();
        listarUsuario = objUsuarioRepo.findAll();
        return listarUsuario;
    }

    @Override
    public Usuario listarUsuarioId(int id) {
        return objUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario crearUsuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario = objUsuarioRepo.save(crearUsuario);
        return nuevoUsuario;
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
        Usuario usuarioParaActualizar = objUsuarioRepo.findById(id).orElse(null);
        usuarioParaActualizar.setNombreUsuario(usuarioActualizado.getNombreUsuario());
        usuarioParaActualizar.setContrasena(usuarioActualizado.getContrasena());
        usuarioParaActualizar.setRol(usuarioActualizado.getRol());
        return objUsuarioRepo.save(usuarioParaActualizar);
    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }
}
