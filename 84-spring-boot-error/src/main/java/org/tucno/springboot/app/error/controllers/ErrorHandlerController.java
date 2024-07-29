package org.tucno.springboot.app.error.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.tucno.springboot.app.error.exceptions.UsuarioNoEncontradoException;

import java.util.Arrays;
import java.util.Date;

// @ControllerAdvice: Anotación que permite definir un controlador global para manejar excepciones en la aplicación.
@ControllerAdvice
public class ErrorHandlerController {

    // @ExceptionHandler: Anotación que permite definir un método que manejará una excepción específica.
    // En este caso, el método manejará excepciones de tipo ArithmeticException.
    // Se puede poner varios métodos con @ExceptionHandler para manejar diferentes excepciones, se ponen entre llaves.
    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticException(Exception e, Model model, HttpServletRequest request) {
        // Se agrega el mensaje de error al modelo
        model.addAttribute("error", "Error de aritmética: " + e.getMessage());
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        model.addAttribute("exception", "ArithmeticException");
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("cause", e.getCause() != null ? e.getCause().toString() : "No hay causa");
        model.addAttribute("trace", Arrays.toString(e.getStackTrace()));
        return "error/aritmetica";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatException(Exception e, Model model, HttpServletRequest request) {
        model.addAttribute("error", "Error de conversión de tipos: " + e.getMessage());
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        model.addAttribute("exception", "NumberFormatException");
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("cause", e.getCause() != null ? e.getCause().toString() : "No hay causa");
        model.addAttribute("trace", Arrays.toString(e.getStackTrace()));
        return "error/numero-formato";
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public String usuarioNoEncontradoException(UsuarioNoEncontradoException e, Model model, HttpServletRequest request) {
        model.addAttribute("error", "Error: " + e.getMessage());
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.NOT_FOUND.value());
        model.addAttribute("timestamp", new Date());
        model.addAttribute("exception", "UsuarioNoEncontradoException");
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("cause", e.getCause() != null ? e.getCause().toString() : "No hay causa");
        model.addAttribute("trace", Arrays.toString(e.getStackTrace()));
        return "error/usuario";
    }
}
