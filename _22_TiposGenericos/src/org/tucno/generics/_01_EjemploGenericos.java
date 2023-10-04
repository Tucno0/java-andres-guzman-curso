package org.tucno.generics;

import org.tucno.poointerfaces.modelo.Cliente;
import org.tucno.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan", "Perez"));

//        Cliente juan = (Cliente) clientes.get(0);
        Cliente juan = clientes.iterator().next(); // otra forma de hacerlo, No es necesario el cast porque ya se sabe que es un Cliente List<Cliente>

        // Genericos
        Cliente[] clientesArreglo = {
                new Cliente("Juan", "Perez"),
                new Cliente("Pedro", "Martinez")
        };

        Integer[] enterosArreglo = {1, 2, 3};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        // Imprimir la lista de clientes
        clientesLista.forEach(System.out::println);
        System.out.println();
        // Imprimir la lista de enteros
        enterosLista.forEach(System.out::println);

        // Ejemplo de uso de genericos con mas de un tipo
        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe", "Luci"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientesPremium = fromArrayToList (
            new ClientePremium[] {
                new ClientePremium("Andres", "Guzman")
            }
        );

        // Comodines en genericos (wildcards)
        System.out.println("\nComodines en genericos (wildcards)");
        System.out.println("Imprimir clientes");
        imprimirClientes(clientes);
        System.out.println("\nImprimir clientesLista");
        imprimirClientes(clientesLista);
        System.out.println("\nImprimir clientesPremium");
        imprimirClientes(clientesPremium);

        // Métodos genéricos máximo de tres objetos usando Comparable
        System.out.println("\nMáximo de 1, 9 y 5 es: " + maximo(1, 9, 5));
        System.out.println("Máximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Máximo de 'a', 'g' y 'c' es: " + maximo('a', 'g', 'c'));
        System.out.println("Maximo de zanahoria, arándano y fresa es: " + maximo("zanahoria", "arándano", "fresa"));
    }

    /**
     * Metodo generico que convierte un arreglo de cualquier tipo a una lista
     *
     * @param c
     * @param <T>
     * @return
     */
    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    /**
     * Metodo generico que convierte un arreglo de cualquier tipo a una lista.
     * Solo acepta tipos que extiendan de Number
     */
    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    /**
     * Metodo generico que convierte un arreglo de cualquier tipo a una lista.
     * Solo acepta tipos que extiendan de Cliente y que implementen la interfaz Comparable
     */
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    /**
     * Metodo generico que recibe dos arreglos de cualquier tipo, al primero lo convierte en lista y al segundo lo imprime
     * @param c Arreglo de cualquier tipo
     * @param x Arreglo de cualquier tipo
     * @return Lista del primer arreglo
     * @param <T> Tipo de dato del primer arreglo
     * @param <G> Tipo de dato del segundo arreglo
     */
    static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    /**
     * Metodo generico que imprime una lista de cualquier tipo que extienda de Cliente
     * @param clientes
     */
    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    // Métodos genéricos máximo de tres objetos usando Comparable
    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) { // compareTo es un método de la interfaz Comparable
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
