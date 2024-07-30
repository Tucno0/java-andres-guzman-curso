package org.tucno.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.tucno.springboot.app.models.entities.Cliente;

// La Clase CrudRepository es una interfaz que nos proporciona Spring Data JPA para realizar operaciones CRUD (Create, Read, Update, Delete) sobre la entidad que le indiquemos
// Tienes que indicarle el tipo de la entidad y el tipo de la clave primaria de la entidad
public interface IClienteDaoCrudRepository extends CrudRepository<Cliente, Long> {

}
