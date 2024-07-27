package org.tucno.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// la anotación @Component indica que la clase MiServicio es un componente de Spring
// Esto lo convierte en un singleton, es decir, solo se crea una instancia de la clase
//@Component("miServicioSimple") // Se puede indicar un nombre para el bean

// la anotación @Service es una especialización de @Component y se utiliza para indicar que la clase es un servicio
// Es una buena práctica utilizar @Service para clases que contienen la lógica de negocio
//@Service

// La anotación @Primary se utiliza para indicar que la clase MiServicio es la implementación principal de la interfaz IServicio
// Si hay más de una implementación de la interfaz IServicio, Spring inyectará la clase MiServicio
//@Primary
public class MiServicio implements IServicio {

    @Override
    public String operacion() {
        return "Ejecutando algún proceso importante pero simple...";
    }
}
