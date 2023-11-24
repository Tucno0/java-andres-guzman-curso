package org.jhampier.java8.lambda;

import org.jhampier.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class _01_EjemploConsumer {
    public static void main(String[] args) {
        // Consumer es una interfaz funcional que recibe un parámetro y no devuelve nada
        // Solo tiene el método accept que recibe un parámetro y no devuelve nada
        Consumer<String> consumidor = saludo -> {
            System.out.println(saludo);
        };
        Consumer<Date> fecha = (fechaActual) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(fechaActual));
        };

        consumidor.accept("Hola Mundo");
        fecha.accept(new Date());


        // BiConsumer es una interfaz funcional que recibe dos parámetros
        BiConsumer<String, Integer> biConsumer = (nombre, edad) -> {
            System.out.println(nombre + " tiene " + edad + " años");
        };

        biConsumer.accept("Juan", 30);

        // Referencia a métodos con ::
        Consumer<String> consumidor2 = System.out::println; // System.out::println es equivalente a x -> System.out.println(x)
        consumidor2.accept("Hola Mundo 2");

        // Arrays.asList es una forma de crear una lista de elementos
        List<String> nombres = Arrays.asList("Juan", "Pedro", "Diego", "Pablo");
        nombres.forEach(consumidor2);

        // Ejemplo de BiConsumer con una clase
        Usuario usuario = new Usuario();
        BiConsumer<Usuario, String> asignarNombre = (persona, nombre) -> {
            persona.setNombre(nombre);
        };
        asignarNombre.accept(usuario, "Juan");
        System.out.println("\nNombre de usuario: " + usuario.getNombre());

        // Suplier es una interfaz funcional que no recibe parámetros y devuelve un valor
        Supplier<String> proveedor = () -> {
            return "Hola Mundo desde Supplier";
        };
        System.out.println(proveedor.get());

        // Suplier para crear un objeto de una clase
        Supplier<Usuario> crearUsuario = () -> {
            return new Usuario();
        };

        Usuario usuario2 = crearUsuario.get();
        usuario2.setNombre("Juanito");
        System.out.println("\nNombre de usuario: " + usuario2.getNombre());
    }

}
