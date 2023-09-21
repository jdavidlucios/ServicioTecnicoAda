package com.awakelab.serviciotecnicoada.restcontroller;

import com.awakelab.serviciotecnicoada.entity.Tecnico;
import com.awakelab.serviciotecnicoada.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnico")
public class TecnicoRestController {

    @Autowired
    ITecnicoService objTecnicoService;

    @GetMapping("/{id}")
    public Tecnico listarTecnicoId(@PathVariable int id) {

        return objTecnicoService.listarTecnicoID(id);
    }

    @PostMapping
    public Tecnico crearTecnico(@RequestBody Tecnico tecnico){

        return objTecnicoService.crearTecnico(tecnico);

    }
    @GetMapping
    public List<Tecnico> listarTecnicos(){

        return objTecnicoService.listarTecnico();
    }

    @PutMapping("/{id}")
    public Tecnico actualizarTecnico(@PathVariable int id, @RequestBody Tecnico tecnico){

        return objTecnicoService.actualizarTecnico(id, tecnico);

    }

    @DeleteMapping("/{id}")
    public void eliminarTecnico(@PathVariable int id){

        objTecnicoService.eliminarTecnico(id);
    }
}