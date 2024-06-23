package org.tucno.webapp.jpa.ejb.repositories;

import org.tucno.webapp.jpa.ejb.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
