package com.ada.serviciotecnicoada.restcontroller;

import com.ada.serviciotecnicoada.entity.Usuario;
import com.ada.serviciotecnicoada.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id){
        return objUsuarioService.listarUsuarioId(id);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuarioNuevo){
        return objUsuarioService.crearUsuario(usuarioNuevo);
    }

    @PutMapping("{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        return objUsuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
    }
}
