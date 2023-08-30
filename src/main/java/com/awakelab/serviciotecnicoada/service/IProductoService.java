package com.awakelab.serviciotecnicoada.service;

import com.awakelab.serviciotecnicoada.entity.Producto;

import java.util.List;

public interface IProductoService {
    public Producto crearProducto(Producto productoCreado);
    Producto actualizarProducto(Producto producto);
    public List<Producto> listarProducto();
    public Producto listaProductoID(int idProducto);
    public void eliminarProducto(Producto producto);
}