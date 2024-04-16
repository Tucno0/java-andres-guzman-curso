package org.tucno.apiservlet.webapp.auth.repositories;

import org.tucno.apiservlet.webapp.auth.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
