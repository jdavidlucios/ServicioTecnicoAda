package com.awakelab.serviciotecnicoada.service;
import com.awakelab.serviciotecnicoada.entity.Producto;
import java.util.List;

public interface IProductoService {
    public Producto crearProducto(Producto nuevoProducto);
    Producto actualizarProducto(int id, Producto producto);
    public List<Producto> listarProducto();
    public Producto listaProductoID(int id);
    public void eliminarProducto(int id);
}