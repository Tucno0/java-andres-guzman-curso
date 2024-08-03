package org.tucno.springboot.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Cliente> index() {
        return clienteService.findAll();
    }
}
