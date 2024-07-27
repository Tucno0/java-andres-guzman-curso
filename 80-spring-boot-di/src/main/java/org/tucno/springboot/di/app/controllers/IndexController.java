package org.tucno.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tucno.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {

    // Inyección de dependencia
    // La anotación @Autowired se utiliza para inyectar una dependencia en un componente de Spring
    // Spring busca un componente de tipo MiServicio y lo inyecta en la variable servicio de tipo MiServicio
    @Autowired
    // La anotación @Qualifier se utiliza para indicar el nombre del bean que se quiere inyectar
//    @Qualifier("miServicioComplejo")
    private IServicio servicio;

    // La anotación @Autowired se puede utilizar en un constructor para inyectar una dependencia
    // No es necesario utilizar la anotación @Autowired si la clase solo tiene un constructor
//    @Autowired
//    public IndexController(IServicio servicio) {
//        this.servicio = servicio;
//    }

    @GetMapping({"/", "", "/index"})
    public String index(Model model) {
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

    public IServicio getServicio() {
        return servicio;
    }

    // La anotación @Autowired se puede utilizar en un método setter para inyectar una dependencia
    // Spring busca un componente de tipo MiServicio y lo inyecta en el método setServicio
//    @Autowired
//    public void setServicio(IServicio servicio) {
//        this.servicio = servicio;
//    }
}
