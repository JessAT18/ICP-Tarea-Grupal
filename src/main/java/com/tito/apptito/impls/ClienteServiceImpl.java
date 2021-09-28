package com.tito.apptito.impls;

import com.tito.apptito.daos.IClienteDao;
import com.tito.apptito.entities.personas.Cliente;
import com.tito.apptito.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao iClienteDao;

    @Override
    public void grabarCliente(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    public List<Cliente> listarTodosLosClientes() {
        return iClienteDao.findAll();
    }

    @Override
    public void borrarClienteById(int id) {
        iClienteDao.deleteById(id);
    }

    @Override
    public Cliente encontrarUnCliente(int id) {
        return iClienteDao.getOne(id);
    }

}
