package com.tito.apptito.impls.ventas;

import com.tito.apptito.daos.ventas.IProductoDao;
import com.tito.apptito.entities.ventas.Producto;
import com.tito.apptito.services.ventas.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private IProductoDao iProductoDao;

    @Override
    public void grabarProducto(Producto producto) {
        iProductoDao.save(producto);
    }

    @Override
    public List<Producto> listarTodosLosProductos() {
        return iProductoDao.findAll();
    }

    @Override
    public void borrarProductoById(int id) {
        iProductoDao.deleteById(id);
    }

    @Override
    public Producto encontrarUnProducto(int id) {
        return iProductoDao.getOne(id);
    }
}
