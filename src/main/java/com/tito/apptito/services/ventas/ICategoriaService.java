package com.tito.apptito.services.ventas;

import com.tito.apptito.entities.ventas.Categoria;

import java.util.List;

public interface ICategoriaService {

    void grabarCategoria(Categoria categoria);

    List<Categoria> listarTodasLasCategorias();

    void borrarCategoriaById(int id);

    Categoria encontrarUnaCategoria(int id);
}
