package org.tucno.springboot.apirest.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.tucno.springboot.apirest.models.entities.Cliente;
import org.tucno.springboot.apirest.models.services.ClienteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @GetMapping("/clientes/{id}")
//    public Cliente getCliente(@PathVariable Long id) {
//        return clienteService.findById(id);
//    }

    @GetMapping("/clientes/{id}")
    // ResponseEntity es una clase que nos permite devolver una respuesta HTTP con un determinado código de estado.
    // En este caso, si el cliente no existe, devolveremos un código 404.
    // El ? indica que el tipo de dato que devolverá será genérico.
    public ResponseEntity<?> getCliente(@PathVariable Long id) {
        Cliente cliente = null;

        // Se crea un objeto de tipo Map para devolver un mensaje personalizado.
        Map<String, Object> response = new HashMap<>();

        try {
            // Se intenta obtener el cliente por su ID.
            cliente = clienteService.findById(id);

        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos.");
            response.put("error", e.getMessage());

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

//    @PostMapping("/clientes")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Cliente addCliente(@RequestBody Cliente cliente) {
//        return clienteService.save(cliente);
//    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        Cliente nuevoCliente = null;
        Map<String, Object> response = new HashMap<>();

        // Si hay errores en la validación, se recorren y se añaden al objeto response.
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .toList();

            response.put("errores", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            nuevoCliente = clienteService.save(cliente);

        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos.");
            response.put("error", e.getMessage());

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido creado con éxito.");
        response.put("cliente", nuevoCliente);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

//    @PutMapping("/clientes/{id}")
//    public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
//        Cliente clienteActual = clienteService.findById(id);
//        clienteActual.setNombre(cliente.getNombre());
//        clienteActual.setApellido(cliente.getApellido());
//        clienteActual.setEmail(cliente.getEmail());
//        return clienteService.save(clienteActual);
//    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> updateCliente(@Valid @RequestBody Cliente cliente, @PathVariable Long id, BindingResult result) {
        Cliente clienteActual = clienteService.findById(id);
        Cliente clienteActualizado = null;

        Map<String, Object> response = new HashMap<>();

        // Si hay errores en la validación, se recorren y se añaden al objeto response.
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .toList();

            response.put("errores", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (clienteActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setEmail(cliente.getEmail());

            clienteActualizado = clienteService.save(clienteActual);

        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la actualización en la base de datos.");
            response.put("error", e.getMessage());

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido actualizado con éxito.");
        response.put("cliente", clienteActualizado);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

//    @DeleteMapping("/clientes/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCliente(@PathVariable Long id) {
//        clienteService.delete(id);
//    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (cliente == null) {
            response.put("mensaje", "Error: no se pudo eliminar, el cliente ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteService.delete(id);

        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la eliminación en la base de datos.");
            response.put("error", e.getMessage());

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
