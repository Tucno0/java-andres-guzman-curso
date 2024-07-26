package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params") // Ruta base
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "Valor por defecto") String texto, Model model) {
		model.addAttribute("titulo" , "Anotacion @RequestParam");
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String mixParams(
		@RequestParam(name = "saludo", required = false, defaultValue = "saludo por defecto") String saludo,
		@RequestParam(name = "numero", required = false, defaultValue = "10") String numero,
		Model model
	) {
		model.addAttribute("titulo" , "Anotacion @RequestParam");
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String mixParams(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("titulo" , "Anotacion @RequestParam");
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}
}
