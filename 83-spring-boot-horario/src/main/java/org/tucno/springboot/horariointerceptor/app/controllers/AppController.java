package org.tucno.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    // Se obtienen los valores de los atributos de configuración del archivo application.properties
    @Value("${config.horario.apertura}")
    private Integer apertura;

    @Value("${config.horario.cierre}")
    private Integer cierre;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido al horario de atención a clientes");
        return "index";
    }

    @GetMapping("/cerrado")
    public String cerrado(Model model) {
        StringBuilder mensaje = new StringBuilder("Cerrado, por favor visítenos desde las ");
        mensaje.append(apertura);
        mensaje.append(" hrs. ");
        mensaje.append("hasta las ");
        mensaje.append(cierre);
        mensaje.append(" hrs. ");

        model.addAttribute("titulo", "Fuera del horario de atención");
        model.addAttribute("mensaje", mensaje.toString());
        return "cerrado";
    }
}
