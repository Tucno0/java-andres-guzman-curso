package org.tucno.springboot.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tucno.springboot.app.models.dao.ClienteDaoInterface;
import org.tucno.springboot.app.models.entities.Cliente;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteDaoInterface clienteDao;

    @Override
    // @Transactional es una anotación que se utiliza para marcar los métodos que se van a ejecutar dentro de una transacción
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return clienteDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.delete(id);
    }
}
