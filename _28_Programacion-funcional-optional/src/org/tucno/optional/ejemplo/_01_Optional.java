package org.tucno.optional.ejemplo;

import javax.swing.text.html.Option;
import java.util.Optional;

public class _01_Optional {
    public static void main(String[] args) {
        // OPTIONAL
        // Es un contenedor que puede o no contener un valor no nulo.
        // Si contiene un valor no nulo, el método isPresent() devuelve true y el método get() devuelve el valor.

        // Optional.of() -> Devuelve un Optional con el valor especificado.
        // Optional.empty() -> Devuelve un Optional vacío.
        // Optional.ofNullable() -> Devuelve un Optional con el valor especificado si no es nulo, de lo contrario devuelve un Optional vacío.

        // Cuando nombre no es nulo.
        String nombre = "Andrés";

        Optional<String> optional = Optional.of(nombre);
        System.out.println("optional = " + optional);

        // isPresent() -> Devuelve true si el valor no es nulo.
        System.out.println("optional.isPresent() = " + optional.isPresent());
        if (optional.isPresent()) {
            // get() -> Devuelve el valor si no es nulo, de lo contrario lanza una excepción NoSuchElementException.
            System.out.println("Hola " + optional.get() + ", usando get() con isPresent() dentro de un if.");
        }

        // ifPresent() -> Ejecuta el código que recibe como parámetro si el valor no es nulo.
        optional.ifPresent(valor -> System.out.println("Hola " + valor + ", usando ifPresent() con una expresión lambda."));

        // isEmpty() -> Devuelve true si el valor es nulo.
        System.out.println("optional.isEmpty() = " + optional.isEmpty());

        // Cuando nombre es nulo.
        nombre = null;
//        optional.of(nombre); // Lanza una excepción NullPointerException.
        optional = Optional.ofNullable(nombre); // permite que el valor sea nulo o no nulo.
        System.out.println("\noptional = " + optional);
        System.out.println("optional.isPresent() = " + optional.isPresent());

        optional.ifPresentOrElse(valor -> System.out.println("Hola " + valor + ", usando ifPresentOrElse() con una expresión lambda."),
                () -> System.out.println("El valor no está presente, usando ifPresentOrElse() con una expresión lambda.")
        );

        // Optional vacío.
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println("\noptionalEmpty = " + optionalEmpty);
        System.out.println("optionalEmpty.isPresent() = " + optionalEmpty.isPresent());
    }
}
