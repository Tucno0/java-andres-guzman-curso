package org.jhampier.anotaciones.ejemplo.procesador;

import org.jhampier.anotaciones.ejemplo.annotations.Init;
import org.jhampier.anotaciones.ejemplo.annotations.JsonAtributo;
import org.jhampier.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class JsonSerializador {
    public static void inicializarObjeto(Object object) {
        if (Objects.isNull(object)) { // Se usa la clase Objects para validar si el objeto es nulo.
            throw new JsonSerializadorException("El objeto a serializar no puede ser nulo");
        }

        Method[] metodos = object.getClass().getDeclaredMethods(); // Se obtienen los métodos de la clase Producto.

        Arrays.stream(metodos)
                .filter(method -> method.isAnnotationPresent(Init.class)) // Se filtran los métodos que tengan la anotación Init.
                .forEach(m -> {
                    try {
                        m.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar el método " + m.getName() + " a JSON, no se puede iniciar el objeto" + e.getMessage());
                    }
                }); // Se invoca el método init(
    }

    public static String convertirAJson(Object object) {
        //        if (object == null) {
        if (Objects.isNull(object)) { // Se usa la clase Objects para validar si el objeto es nulo.
            throw new JsonSerializadorException("El objeto a serializar no puede ser nulo");
        }

        inicializarObjeto(object); // Se inicializa el objeto.

        // API de reflexión de Java

        // La API de reflexión de Java proporciona la capacidad de inspeccionar y modificar el comportamiento de las clases en tiempo de ejecución.
        // La API de reflexión de Java se puede usar para inspeccionar atributos, métodos y constructores de clases.

        // Field es una clase que representa un atributo de una clase.
        // Se puede obtener una lista de atributos de una clase con el método getDeclaredFields() de la clase Class.

        Field[] atributos = object.getClass().getDeclaredFields(); // Se obtienen los atributos de la clase Producto.
        // Se recibe un objeto y se retorna un String con el objeto serializado en JSON.
        return Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class)) // Se filtran los atributos que tengan la anotación JsonAtributo.
                .map( field -> {
                    field.setAccessible(true); // Se habilita el acceso al atributo.
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("") // Se obtiene el nombre del atributo.
                            ? field.getName() // Si el atributo no tiene nombre se obtiene el nombre del atributo.
                            : field.getAnnotation(JsonAtributo.class).nombre(); // Si el atributo tiene nombre se obtiene el nombre del atributo.

                    try {
                        Object valor = field.get(object); // Se obtiene el valor del atributo.

                        // Si el atributo tiene la anotación capitalizar y el valor es un String.
                        if (field.getAnnotation(JsonAtributo.class).capitalizar() && valor instanceof String) {
                            String nuevoValor = ((String) valor) // Se convierte el valor a String.
                                    .substring(0, 1) // Se obtiene el primer caracter del String.
                                    .toUpperCase() // Se convierte el primer caracter a mayúscula.
                                    .concat(((String) valor)
                                            .substring(1) // Se obtiene el resto del String.
                                            .toLowerCase() // Se convierte el resto del String a minúscula.
                                    ); // Se concatena el primer caracter con el resto del String.

                            field.set(object, nuevoValor); // Se asigna el nuevo valor al atributo.
                        }
                        // Se retorna el nombre del atributo y el valor del atributo.
                        return "\"" + nombre + "\":\"" + field.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException ("Error al serializar el atributo " + field.getName() + " a JSON");
                    }
                })
                .reduce("{", (acumulador, valor) -> {
                    if (acumulador.equals("{")) { // Si es el primer atributo se concatena el atributo sin la coma.
                        return acumulador.concat(valor);
                    } else { // Si no es el primer atributo se concatena el atributo con la coma.
                        return acumulador.concat(",").concat(valor);
                    }
                }) // Se reduce la lista de atributos a un solo String.
                .concat("}"); // Se concatena el cierre del objeto JSON.
    }
}
