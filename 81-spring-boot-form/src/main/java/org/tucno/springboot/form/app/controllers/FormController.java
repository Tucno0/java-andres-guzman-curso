package org.tucno.springboot.form.app.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.tucno.springboot.form.app.editors.NombreMayusculaEditor;
import org.tucno.springboot.form.app.editors.PaisPropertyEditor;
import org.tucno.springboot.form.app.editors.RolesEditor;
import org.tucno.springboot.form.app.models.domain.Pais;
import org.tucno.springboot.form.app.models.domain.Role;
import org.tucno.springboot.form.app.models.domain.Usuario;
import org.tucno.springboot.form.app.services.PaisService;
import org.tucno.springboot.form.app.services.RoleService;
import org.tucno.springboot.form.app.validators.UsuarioValidator;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario") // Se utiliza para mantener el objeto Usuario en la sesión y no perder los datos al regresar al formulario
public class FormController {
    @Autowired
    private UsuarioValidator validator;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolesEditor roleEditor;

    // Se registra el validador en el controlador para que Spring lo utilice
    @InitBinder
    // WebDataBinder se utiliza para registrar los validadores en el controlador
    public  void initBinder(WebDataBinder binder) {
        // se registra el validador en el WebDataBinder, esto reemplaza el validador por defecto de las anotaciones de validación
//        binder.setValidator(validator);

        // (Recomendado) Se registra el validador en el WebDataBinder para que se utilice junto con el validador por defecto de las anotaciones de validación
        binder.addValidators(validator);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Se establece que la fecha no sea leniente, es decir, que no acepte fechas incorrectas
        dateFormat.setLenient(false);
        // Se registra un CustomDateEditor para dar formato a la fecha
        // Si se pone el nombre del campo, se aplica solo a ese campo, si se pone null, se aplica a todos los campos de tipo Date
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));

        // Se registra un PropertyEditor personalizado para convertir el nombre a mayúsculas
        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());

        // Se registra un PropertyEditor personalizado para convertir el id del país a un objeto Pais
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);

        // Se registra un PropertyEditor personalizado para convertir el id del rol a un objeto Role
        binder.registerCustomEditor(Role.class, "roles", roleEditor);
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("México", "España", "Colombia", "Argentina", "Perú", "Chile", "Venezuela");
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        Map<String, String> paises = new LinkedHashMap<>();
        paises.put("ES", "España");
        paises.put("MX", "México");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Perú");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");
        return paises;
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap() {
        Map<String, String> roles = new LinkedHashMap<>();
        roles.put("ROLE_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderador");
        return roles;
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return roleService.listar();
    }

    @ModelAttribute("generos")
    public List<String> genero() {
        return Arrays.asList("Hombre", "Mujer");
    }

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario(); // Se crea un objeto Usuario para enviarlo al formulario y que no genere errores
        usuario.setId("12345");
        usuario.setCodigo("12.456.789-A");
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setUsername("johndoe");
        usuario.setPassword("12345");
        usuario.setEmail("juan@gmaial.com");
        usuario.setEdad(30);
        usuario.setFechaNacimiento(new Date());
        usuario.setPais(new Pais(1, "ES", "España"));
        usuario.setRoles(List.of(new Role(2, "Usuario", "ROLE_USER")));
        usuario.setHabilitado(true);
        usuario.setValorSecreto("Algun valor secreto ****");

        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    // @RequestParam se utiliza para obtener los valores de los campos del formulario
    // Model model se utiliza para enviar datos a la vista
    public String procesar(
        Model model,
//        @RequestParam(name = "username") String username,
//        @RequestParam(name = "password") String password,
//        @RequestParam(name = "email") String email

        @Valid // @Valid se utiliza para validar el objeto Usuario con las anotaciones de validación
        @ModelAttribute("usuario") // @ModelAttribute se utiliza para mapear el objeto Usuario con el formulario y enviarlo a la vista con el nombre "user"
        Usuario usuario, // Spring automáticamente mapea los campos del formulario con los atributos del objeto Usuario
        BindingResult result // BindingResult se utiliza para obtener los errores de validación, siempre debe ir después del objeto a validar (Usuario)
    ) {
//        Usuario usuario = new Usuario();
//        usuario.setUsername(username);
//        usuario.setPassword(password);
//        usuario.setEmail(email);

        // Si se usa el InitBinder, ya no es necesario validar el objeto Usuario con el validador
//        validator.validate(usuario, result); // Se valida el objeto Usuario con el validador


        // Si hay errores de validación, se regresa al formulario
        if (result.hasErrors()) {
            // Ya no es necesario enviar los datos a la vista, ya que Spring se encarga de enviar el objeto Usuario con los errores
//            Map<String, String> errores = new HashMap<>();
//
//            // Se recorren los errores y se guardan en un mapa para mostrarlos en la vista
//            result.getFieldErrors().forEach(err -> {
//                errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(Objects.requireNonNull(err.getDefaultMessage())));
//            });
//
//            model.addAttribute("error", errores);
            model.addAttribute("titulo", "Resultado del formulario");
            return "form";
        }

//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//        model.addAttribute("email", email);
//        status.setComplete(); // Se limpian los datos del objeto Usuario de la sesión

        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(
            // @SessionAttribute se utiliza para obtener el objeto Usuario de la sesión y enviarlo a la vista
            @SessionAttribute(name = "usuario", required = false) Usuario usuario,
            Model model,
            // SessionStatus se utiliza para limpiar los datos del objeto Usuario de la sesión al finalizar el proceso
            SessionStatus status
    ) {
        // Si el objeto Usuario es nulo, se redirige al formulario
        if (usuario == null) {
            return "redirect:/form";
        }

        // Como el usuario se obtiene de la sesión, ya no es necesario enviarlo a la vista con el Model
        model.addAttribute("titulo", "Resultado del formulario");
        status.setComplete(); // Se limpian los datos del objeto Usuario de la sesión

        return "resultado";
    }
}
