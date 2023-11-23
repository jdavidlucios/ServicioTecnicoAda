package com.ada.serviciotecnicoada.service.serviceImpl;

import com.ada.serviciotecnicoada.entity.Producto;
import com.ada.serviciotecnicoada.repository.IProductoRepository;
import com.ada.serviciotecnicoada.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoRepository objProductoRepo;
    @Override
    public List<Producto> listarProductos() {
        List<Producto> listarProductos = new ArrayList<>();
        listarProductos = objProductoRepo.findAll();
        return listarProductos;
    }

    @Override
    public Producto listarProductoId(int id)  {
        return objProductoRepo.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        Producto nuevoProducto = new Producto();
        nuevoProducto = objProductoRepo.save(producto);
        return nuevoProducto;
    }

    @Override
    public Producto actualizarProducto(int id, Producto productoActualizado) {
        Producto productoParaActualizar = objProductoRepo.findById(id).orElse(null);
        productoParaActualizar.setCodigo_producto(productoActualizado.getCodigo_producto());
        productoParaActualizar.setNombre_producto(productoActualizado.getNombre_producto());
        return objProductoRepo.save(productoActualizado);
    }

    @Override
    public void eliminarProducto(int id)  {
        objProductoRepo.deleteById(id);
    }
}
