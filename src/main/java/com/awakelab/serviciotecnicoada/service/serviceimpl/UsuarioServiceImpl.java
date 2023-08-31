package com.awakelab.serviciotecnicoada.service.serviceimpl;
import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.entity.Usuario;
import com.awakelab.serviciotecnicoada.repository.IUsuarioRepository;
import com.awakelab.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuarioCreado) {
        Usuario nuevoUsuario = new Tecnico();
        nuevoUsuario = objUsuarioRepo.save(usuarioCreado);
        return nuevoUsuario;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        try {
            if (objUsuarioRepo.existsById(usuario.getId())){
                usuario.setId(usuario.getId());
                objUsuarioRepo.save(usuario);
            }else {
                throw new RuntimeException("UPS!!!! " + usuario.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listarUsuario = new ArrayList<Usuario>();
        listarUsuario = objUsuarioRepo.findAll();
        return listarUsuario;
    }

    @Override
    public Usuario listarUsuarioID(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElse(null);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        try {
            if (objUsuarioRepo.existsById(usuario.getId())){
                objUsuarioRepo.deleteById(usuario.getId());
            }else {
                throw new RuntimeException("UPS!!!! " + usuario.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Usuario borrado exitosamente");
    }
}
