package org.tucno.springboot.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.tucno.springboot.apirest.models.entities.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
