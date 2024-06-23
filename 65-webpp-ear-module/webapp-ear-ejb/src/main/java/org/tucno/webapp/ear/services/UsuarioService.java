package org.tucno.webapp.ear.services;

import jakarta.ejb.Local;
import org.tucno.webapp.ear.entities.Usuario;

import java.util.List;

@Local
public interface UsuarioService {
    List<Usuario> listar();
}
