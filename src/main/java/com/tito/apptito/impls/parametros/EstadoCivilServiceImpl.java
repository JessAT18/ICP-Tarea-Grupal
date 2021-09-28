package com.tito.apptito.impls.parametros;

import com.tito.apptito.daos.parametros.IEstadoCivilDao;
import com.tito.apptito.entities.parametros.EstadoCivil;
import com.tito.apptito.services.parametros.IEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilServiceImpl implements IEstadoCivilService {

    @Autowired
    private IEstadoCivilDao iEstadoCivilDao;
    @Override
    public void grabarEstadoCivil(EstadoCivil estadoCivil) {
        iEstadoCivilDao.save(estadoCivil);
    }

    @Override
    public List<EstadoCivil> listarTodosLosEstadosCiviles() {
        return iEstadoCivilDao.findAll();
    }

    @Override
    public void borrarEstadoCivilById(int id) {
        iEstadoCivilDao.deleteById(id);
    }

    @Override
    public EstadoCivil encontrarUnEstadoCivil(int id) {
        return iEstadoCivilDao.getOne(id);
    }
}
