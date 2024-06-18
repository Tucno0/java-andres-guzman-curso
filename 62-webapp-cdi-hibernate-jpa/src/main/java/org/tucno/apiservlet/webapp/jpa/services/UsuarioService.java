package org.tucno.apiservlet.webapp.jpa.services;

import org.tucno.apiservlet.webapp.jpa.models.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String email, String password);
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    void guardar(Usuario usuario);
    void eliminar(Long id);
}
