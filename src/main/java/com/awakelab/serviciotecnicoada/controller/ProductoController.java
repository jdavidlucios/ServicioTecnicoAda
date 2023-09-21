package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Producto;
import com.awakelab.serviciotecnicoada.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productoCreado")
public class ProductoController {

    @Autowired
    IProductoService objProductoService;

    @GetMapping
    public String listarProducto(Model model){
        List<Producto> listaProducto = objProductoService.listarProducto();
        model.addAttribute("atributoListaProducto", listaProducto);
        return "TemplateProductos";
    }

    @PostMapping("/crearProducto")
    public String crearProducto(@ModelAttribute Producto producto) {
        objProductoService.crearProducto(producto);
        return "redirect:/productoCreado";
    }

    @PostMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@ModelAttribute int id) {
        objProductoService.eliminarProducto(id);
        return "redirect:/productoCreado";
    }

    @GetMapping("/actualizarProducto/{id}")
    public String actualizarProducto(@PathVariable int id, @ModelAttribute Producto producto){
        objProductoService.actualizarProducto(id, producto);
        return "redirect:/productoCreado";
    }

}
