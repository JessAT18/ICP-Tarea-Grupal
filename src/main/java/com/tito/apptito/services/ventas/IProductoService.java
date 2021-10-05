package com.tito.apptito.services.ventas;

import com.tito.apptito.entities.ventas.Producto;

import java.util.List;

public interface IProductoService {

    void grabarProducto(Producto producto);

    List<Producto> listarTodosLosProductos();

    void borrarProductoById(int id);

    Producto encontrarUnProducto(int id);
}
