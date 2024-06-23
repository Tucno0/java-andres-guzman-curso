package org.tucno.webapp.ear.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.tucno.webapp.ear.entities.Usuario;
import org.tucno.webapp.ear.repositories.UsuarioRepository;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }
}
