package com.ada.serviciotecnicoada.restcontroller;

import com.ada.serviciotecnicoada.entity.Tecnico;
import com.ada.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tecnico")
public class TecnicoRestController {
    @Autowired
    ITecnicoService objTecnicoService;

    @GetMapping
    public List<Tecnico> listarTecnicos(){
        return objTecnicoService.listarTecnicos();
    }

    @GetMapping("/{id}")
    public Tecnico listarTecnicoId(@PathVariable int id){
        return objTecnicoService.listarTecnicoId(id);
    }

    @PostMapping
    public Tecnico crearTecnico(@RequestBody Tecnico tecnicoNuevo){
        return objTecnicoService.crearTecnico(tecnicoNuevo);
    }

    @PutMapping("{id}")
    public Tecnico actualizarTecnico(@PathVariable int id, @RequestBody Tecnico tecnico){
        return objTecnicoService.actualizarTecnico(id, tecnico);
    }

    @DeleteMapping("/{id}")
    public void eliminarTecnico(@PathVariable int id){
        objTecnicoService.eliminarTecnico(id);
    }
}
