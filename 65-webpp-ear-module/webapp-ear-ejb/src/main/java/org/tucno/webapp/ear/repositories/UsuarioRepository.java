package org.tucno.webapp.ear.repositories;

import org.tucno.webapp.ear.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}
