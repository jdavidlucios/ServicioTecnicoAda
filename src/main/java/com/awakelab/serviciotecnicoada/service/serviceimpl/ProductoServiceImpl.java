package com.awakelab.serviciotecnicoada.service.serviceimpl;

import com.awakelab.serviciotecnicoada.entity.Producto;
import com.awakelab.serviciotecnicoada.repository.IProductoRepository;
import com.awakelab.serviciotecnicoada.service.IProductoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository objProductoRepo;

    @Override
    public Producto crearProducto(Producto nuevoProducto) {
        Producto productoCreado = new Producto();
        productoCreado = objProductoRepo.save(nuevoProducto);
        return productoCreado;
    }

    @Override
    public Producto actualizarProducto(int id, Producto producto) {
        Producto productoEncontrado = objProductoRepo.findById(id).orElse(null);
        productoEncontrado.setNombreProducto(producto.getNombreProducto());
        return objProductoRepo.save(productoEncontrado);
    }

    @Override
    public List<Producto> listarProducto() {
        List<Producto> listarProducto = new ArrayList<Producto>();
        listarProducto = objProductoRepo.findAll();
        return listarProducto;
    }

    @Override
    public Producto listaProductoID(int id) {
        return objProductoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(int id) {
        objProductoRepo.deleteById(id);

        System.out.println("Producto borrado exitosamente");
    }
}