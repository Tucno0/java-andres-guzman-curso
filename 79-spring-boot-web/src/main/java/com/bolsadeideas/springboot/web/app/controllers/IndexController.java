package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app") // Ruta base
public class IndexController {
	
	// Value nos trae los valores de la propiedades de las variables de entorno
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	// por defecto es de tipo GET
//	@RequestMapping(value = "/index")
	// @GetMapping tambien hace lo mismo
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";	
	}
	
	@GetMapping({"/index2"})
	public String index2(ModelMap model) {
		model.addAttribute("titulo", "Hola spring framework con Model");
		return "index";	
	}
	
	@GetMapping({"/index3"})
	public String index3(Map<String, Object> model) {
		model.put("titulo", "Hola spring framework con Map");
		return "index";	
	}
	
	@GetMapping({"/index4"})
	public ModelAndView index4(ModelAndView mv) {
		mv.addObject("titulo", "Hola spring framework con ModelAndView");
		mv.setViewName("index");
		return mv;	
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhampier");
		usuario.setApellido("Tucno");
		usuario.setEmail("jhampier@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
//		List<Usuario> usuarios = Arrays.asList(
//			new Usuario("Jhampier", "Tucno", "jhampier@gmail.com"),
//			new Usuario("John", "Doe", "john@gmail.com"),
//			new Usuario("Jane", "Doe", "jane@gmail.com")
//		);
		
		model.addAttribute("titulo", textoListar);
//		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
	// se pasa el nombre en la anotacion
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(
			new Usuario("Jhampier", "Tucno", "jhampier@gmail.com"),
			new Usuario("John", "Doe", "john@gmail.com"),
			new Usuario("Jane", "Doe", "jane@gmail.com")
		);
		
		return usuarios;
	}
	
}
