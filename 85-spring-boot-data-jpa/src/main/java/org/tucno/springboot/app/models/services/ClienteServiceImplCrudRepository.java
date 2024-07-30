package org.tucno.springboot.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tucno.springboot.app.models.dao.ClienteDaoInterface;
import org.tucno.springboot.app.models.dao.IClienteDaoCrudRepository;
import org.tucno.springboot.app.models.entities.Cliente;

import java.util.List;

@Service
@Primary
public class ClienteServiceImplCrudRepository implements ClienteService {
    @Autowired
    // Se van a usar las operaciones CRUD de la interfaz IClienteDaoCrudRepository que extiende de CrudRepository
    private IClienteDaoCrudRepository clienteDao;

    @Override
    // @Transactional es una anotación que se utiliza para marcar los métodos que se van a ejecutar dentro de una transacción
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        // Si el objeto no se encuentra, se devuelve null
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }
}
