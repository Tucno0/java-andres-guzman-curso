package org.tucno.springboot.app.error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.tucno.springboot.app.error.exceptions.UsuarioNoEncontradoException;
import org.tucno.springboot.app.error.models.Usuario;
import org.tucno.springboot.app.error.services.UsuarioService;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/index"})
    public String index() {
        // Se genera una excepción de tipo ArithmeticException
        Integer valor = 100/0;
//        Integer valor = Integer.parseInt("10x");

        return "index";
    }

    @GetMapping({"/ver/{id}"})
    public String ver(@PathVariable Integer id, Model model) {
//        Usuario usuario = usuarioService.obtenerPorId(id);
//
//        if (usuario == null) {
//            throw new UsuarioNoEncontradoException(id);
//        }

        Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id));

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
        return "ver";
    }
}
