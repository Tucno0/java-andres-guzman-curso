package org.tucno.webapp.jsf3.jaas.services;

import jakarta.annotation.Resource;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.tucno.webapp.jsf3.jaas.entities.Categoria;
import org.tucno.webapp.jsf3.jaas.entities.Producto;
import org.tucno.webapp.jsf3.jaas.repositories.CrudRepository;
import org.tucno.webapp.jsf3.jaas.repositories.ProductoRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

// La anotación @Stateless se utiliza para definir un EJB sin estado.
// Lo que significa que el contenedor no necesita mantener el estado del EJB entre las invocaciones de los métodos.
// Un EJB sin estado no guarda información de estado entre las invocaciones de los métodos.
@Stateless
// La anotación @DeclareRoles se utiliza para declarar los roles que se pueden asignar a los usuarios.
@DeclareRoles({"USER", "ADMIN"})
public class ProductoServiceImpl implements ProductoService {
    @Inject
    private ProductoRepository productoRepository;

    @Inject
    private CrudRepository<Categoria> categoriaRepository;

    @Resource // La anotación @Resource se utiliza para inyectar la información de contexto de la sesión.
    private SessionContext ctx;

    @Override
    @PermitAll // La anotación @PermitAll se utiliza para permitir el acceso a todos los usuarios.
    public List<Producto> listar() {
        Principal usuario = ctx.getCallerPrincipal(); // Se obtiene el usuario autenticado.
        String username = usuario.getName(); // Se obtiene el nombre del usuario autenticado.

        System.out.println("username = " + username);

        if (ctx.isCallerInRole("ADMIN")) { // Se verifica si el usuario autenticado tiene el rol de ADMIN.
            System.out.println("El usuario tiene el rol de ADMIN");
        } else if (ctx.isCallerInRole("USER")) { // Se verifica si el usuario autenticado tiene el rol de USER.
            System.out.println("El usuario tiene el rol de USER");
        } else {
            System.out.println("El usuario no tiene ningún rol");
//            throw new SecurityException("Acceso denegado");
        }

        return productoRepository.listar();
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"}) // La anotación @RolesAllowed se utiliza para permitir el acceso a los usuarios con roles específicos.
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(productoRepository.porId(id));
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void guardar(Producto producto) {
        productoRepository.guardar(producto);
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void eliminar(Long id) {
        productoRepository.eliminar(id);
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.buscarPorNombre(nombre);
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public Optional<Categoria> categoriaPorId(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }
}
