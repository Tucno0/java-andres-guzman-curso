package org.tucno.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

// Tambien las clases POJOs pueden ser componentes de Spring
@Component
// La anotacion @RequestScope se puede usar para indicar que el alcance del componente es por peticion (Request)
@RequestScope

// La anotacion @SessionScope se puede usar para indicar que el alcance del componente es por sesion (Session)
// En Spring, el alcance de la sesion es el alcance de la sesion web y se puede usar para compartir informacion entre diferentes componentes de la sesion
//@SessionScope

// La anotacion @ApplicationScope se puede usar para indicar que el alcance del componente es por aplicacion (Application)
// En Spring, el alcance de la aplicacion es el alcance de la aplicacion web y se puede usar para compartir informacion entre diferentes componentes de la aplicacion
// Muy parecido al singleton, pero con la diferencia de que el alcance de la aplicacion es solo para aplicaciones web
//@ApplicationScope

// La interfaz Serializable se utiliza para indicar que la clase puede ser serializada
// La serializacion es el proceso de convertir un objeto en una secuencia de bytes para almacenarlo o transmitirlo a la memoria, a una base de datos o a un archivo
public class Cliente implements Serializable {
    private static final long serialVersionUID = 914654654654654654L;

    // La anotacion @Value permite inyectar valores de propiedades de un archivo de configuracion
    @Value("${cliente.nombre}")
    private String nombre;

    @Value("${cliente.apellido}")
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
