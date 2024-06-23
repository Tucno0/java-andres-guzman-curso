package org.tucno.webapp.jpa.ejb.services;

import jakarta.ejb.Local;
import org.tucno.webapp.jpa.ejb.models.entities.Usuario;

import java.util.List;
import java.util.Optional;

@Local
public interface UsuarioService {
    Optional<Usuario> login(String email, String password);
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    void guardar(Usuario usuario);
    void eliminar(Long id);
}
