package com.awakelab.serviciotecnicoada.service.serviceimpl;

import com.awakelab.serviciotecnicoada.entity.Producto;
import com.awakelab.serviciotecnicoada.repository.IProductoRepository;
import com.awakelab.serviciotecnicoada.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository objProductoRepo;

    @Override
    public Producto crearProducto(Producto productoCreado) {
        Producto nuevoProducto = new Producto();
        nuevoProducto = objProductoRepo.save(productoCreado);
        return nuevoProducto;
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        try {
            if (objProductoRepo.existsById(producto.getId())){
                producto.setId(producto.getId());
                objProductoRepo.save(producto);
            }else {
                throw new RuntimeException("UPS!!!! " + producto.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> listarProducto() {
        List<Producto> listarProducto = new ArrayList<Producto>();
        listarProducto = objProductoRepo.findAll();
        return listarProducto;
    }

    @Override
    public Producto listaProductoID(int idProducto) {
        return objProductoRepo.findById(idProducto).orElse(null);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        try {
            if (objProductoRepo.existsById(producto.getId())){
                objProductoRepo.deleteById(producto.getId());
            }else {
                throw new RuntimeException("UPS!!!! " + producto.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Producto borrado exitosamente");

}
