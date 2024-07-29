package org.tucno.springboot.app.error.services;

import org.springframework.stereotype.Service;
import org.tucno.springboot.app.error.models.Usuario;

import java.util.List;
import java.util.Optional;

// @Service: anotación que indica que la clase es un servicio de Spring y se puede inyectar en otras clases.
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private List<Usuario> usuarios;

    // Constructor de la clase UsuarioServiceImpl
    public UsuarioServiceImpl() {
        // Se inicializa la lista de usuarios
        this.usuarios = List.of(
            new Usuario(1, "Andres", "Guzman"),
            new Usuario(2, "Pepe", "Gomez"),
            new Usuario(3, "Luci", "Martinez"),
            new Usuario(4, "Juan", "Fernandez"),
            new Usuario(5, "Bruce", "Lee"),
            new Usuario(6, "Bruce", "Willis"),
            new Usuario(7, "Bruce", "Springsteen")
        );
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;
        for (Usuario usuario : usuarios) {
            if (id.equals(usuario.getId())) {
                resultado = usuario;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = obtenerPorId(id);
        return Optional.ofNullable(usuario);
    }
}
