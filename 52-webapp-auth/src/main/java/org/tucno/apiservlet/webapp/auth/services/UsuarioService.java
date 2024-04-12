package org.tucno.apiservlet.webapp.auth.services;

import org.tucno.apiservlet.webapp.auth.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String email, String password);
}
