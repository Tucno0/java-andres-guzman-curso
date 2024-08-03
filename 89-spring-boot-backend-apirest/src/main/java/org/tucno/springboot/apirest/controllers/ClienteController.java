package org.tucno.springboot.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.tucno.springboot.apirest.models.entities.Cliente;
import org.tucno.springboot.apirest.models.services.ClienteService;

import java.util.List;

// La anotación @RestController indica que la clase es un controlador REST.
// Es decir, que se encargará de manejar las peticiones HTTP y devolverá los datos en formato JSON.
// A diferencia de @Controller, que se utiliza para devolver una vista HTML.
@RestController
@RequestMapping("/api")
// La anotación @CrossOrigin permite que se pueda acceder a los datos desde un servidor distinto al que sirve la aplicación.
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> getclientes() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteActual = clienteService.findById(id);
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());
        return clienteService.save(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
