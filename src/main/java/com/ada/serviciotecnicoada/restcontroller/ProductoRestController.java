package com.ada.serviciotecnicoada.restcontroller;

import com.ada.serviciotecnicoada.entity.Producto;
import com.ada.serviciotecnicoada.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {
    @Autowired
    IProductoService objProductoService;

    @GetMapping
    public List<Producto> listarProductos(){
        return objProductoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto listarProductoId(@PathVariable int id){
        return objProductoService.listarProductoId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto productoNuevo){
        return objProductoService.crearProducto(productoNuevo);
    }

    @PutMapping("{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto producto){
        return objProductoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id){
        objProductoService.eliminarProducto(id);
    }
}