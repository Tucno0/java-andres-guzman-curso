package org.tucno.apiservlet.webapp.auth.services;

import org.tucno.apiservlet.webapp.auth.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String email, String password);
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    void guardar(Usuario usuario);
    void eliminar(Long id);
}
