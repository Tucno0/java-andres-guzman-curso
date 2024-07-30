package org.tucno.springboot.app.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.tucno.springboot.app.models.entities.Cliente;
import org.tucno.springboot.app.models.services.ClienteService;

import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    // Busca la implementación de la interfaz ClienteDaoInterface y la inyecta en el controlador
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }

    @GetMapping("/form")
    // Se crea un objeto de tipo Map para pasar datos al formulario
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("titulo", "Formulario de Cliente");
        model.put("cliente", cliente);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }
        this.clienteService.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.findOne(id);
        } else {
            return "redirect:/listar";
        }
        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        return "form";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }
}
