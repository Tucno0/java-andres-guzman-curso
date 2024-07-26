package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
//		return "redirect:/app/index"; // Redirige a una runta dentro de la app
//		return "redirect:https://www.google.com/";
		
		return "forward:/app/index"; // Redirige a esa ruta pero sin recargar la pagina
	}
}
