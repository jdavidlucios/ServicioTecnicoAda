package com.awakelab.serviciotecnicoada.controller;

import com.awakelab.serviciotecnicoada.entity.Producto;
import com.awakelab.serviciotecnicoada.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> listaProductos = productoService.listarProductos();
        model.addAttribute("atributoListaProductos", listaProductos);
        return "templateListarProductos";
    }

    @GetMapping("/crearProducto")
    public String mostrarFormularioCrearProducto(Model model) {
        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario
        return "templateFormularioCrearProducto";
    }

    @PostMapping("/crearProducto")
    public String crearProducto(@ModelAttribute Producto producto) {
        productoService.crearProducto(producto);
        return "redirect:/producto";
    }

    @PostMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return "redirect:/producto";
    }

    @GetMapping("/editarProducto/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);

        if (producto == null) {
            // Manejo de error si el producto no existe
            return "redirect:/producto";
        }

        // Aquí puedes agregar lógica para obtener los datos necesarios, si es necesario

        model.addAttribute("producto", producto);
        return "templateFormularioEditarProducto";
    }

    @PostMapping("/editarProducto/{id}")
    public String actualizarProducto(@PathVariable int id, @ModelAttribute Producto producto) {
        // Lógica para actualizar el producto en la base de datos
        productoService.actualizarProducto(producto);
        // Redirecciona a la página de lista de productos o a donde desees después de la edición
        return "redirect:/producto";
    }
}
