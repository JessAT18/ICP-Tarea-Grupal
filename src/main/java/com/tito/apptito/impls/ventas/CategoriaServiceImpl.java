package com.tito.apptito.impls.ventas;

import com.tito.apptito.daos.ventas.ICategoriaDao;
import com.tito.apptito.entities.ventas.Categoria;
import com.tito.apptito.services.ventas.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    @Autowired
    private ICategoriaDao iCategoriaDao;

    @Override
    public void grabarCategoria(Categoria categoria) {
        iCategoriaDao.save(categoria);
    }

    @Override
    public List<Categoria> listarTodasLasCategorias() {
        return iCategoriaDao.findAll();
    }

    @Override
    public void borrarCategoriaById(int id) {
        iCategoriaDao.deleteById(id);
    }

    @Override
    public Categoria encontrarUnaCategoria(int id) {
        return iCategoriaDao.getOne(id);
    }
}
