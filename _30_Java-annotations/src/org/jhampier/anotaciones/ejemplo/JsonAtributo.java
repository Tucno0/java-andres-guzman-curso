package org.jhampier.anotaciones.ejemplo;

import java.lang.annotation.*;

// ANOTACIONES
// Las anotaciones son metadatos que se pueden agregar a los elementos de un programa de Java.
// Las anotaciones no afectan directamente el funcionamiento del código al que se aplican.
// Las anotaciones se pueden usar para procesar y validar el código en tiempo de compilación, tiempo de ejecución y tiempo de implementación.
// Su sintaxis es @interface nombreAnotacion { } y se pueden agregar atributos a la anotación.
// Los atributos se definen como métodos sin parámetros y sin excepciones, y el valor de retorno del método define el tipo de atributo.
// Las anotaciones se pueden aplicar a clases, métodos, variables, parámetros y paquetes.

@Documented // Indica que los elementos anotados con esta anotación deben documentarse por la herramienta de documentación.
//@Inherited // Indica que la anotación se hereda de la superclase.
@Target(ElementType.FIELD) // Indica que la anotación solo se puede aplicar a campos.
@Retention(RetentionPolicy.RUNTIME) // Indica que la anotación se conserva en tiempo de ejecución.
public @interface JsonAtributo {
    String nombre() default ""; // Atributo nombre con valor por defecto. Se puede omitir el atributo si se usa el valor por defecto.
    boolean capitalizar() default false; // Atributo capitalizar con valor por defecto.
}
