package org.tucno.colecciones.list;

import org.tucno.colecciones.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class _10_LinkedList_ListIterator {
    public static void main(String[] args) {
        // LINKEDLIST
        // Implementa la interfaz List y la interfaz Deque
        // Es una lista doblemente enlazada (cada elemento tiene una referencia al anterior y al siguiente)
        // Es más lenta que ArrayList en la mayoría de las operaciones
        // Sirve para insertar y eliminar elementos en cualquier posición de la lista de forma eficiente
        // Se puede hacer cola (FIFO) o pila (LIFO)

        LinkedList<Alumno> enlazada = new LinkedList<>();

        // size() devuelve el número de elementos de la lista
        System.out.println("enlazada.size() = " + enlazada.size());
        // isEmpty() devuelve true si la lista está vacía
        System.out.println("enlazada.isEmpty() = " + enlazada.isEmpty());

        enlazada.add(new Alumno("Juan", 5));
        enlazada.add(new Alumno("Pedro", 6));
        enlazada.add(new Alumno("Alberto", 4));
        enlazada.add(new Alumno("Luci", 4));
        enlazada.add(new Alumno("Andres", 3));
        enlazada.add(new Alumno("Zeus", 2));
        enlazada.add(new Alumno("Zeus", 2));
        enlazada.add(new Alumno("Zeus2", 2));
        enlazada.add(new Alumno("Lucas", 2));

        // addFirst() añade un elemento al principio de la lista
        enlazada.addFirst(new Alumno("Primero", 1));
        // addLast() añade un elemento al final de la lista
        enlazada.addLast(new Alumno("Ultimo", 10));

        System.out.println("\nIterando con for");
        enlazada.forEach( a -> System.out.println("\t" + enlazada.indexOf(a) + " : " + a));

        System.out.println("\nal.size() = " + enlazada.size());

        // getFirst() devuelve el primer elemento de la lista, si está vacía lanza una excepción NoSuchElementException
        System.out.println("\nenlazada.getFirst() = " + enlazada.getFirst());
        // peekFirst() devuelve el primer elemento de la lista, si está vacía devuelve null
        System.out.println("enlazada.peekFirst() = " + enlazada.peekFirst());
        // getLast() devuelve el último elemento de la lista, si está vacía lanza una excepción NoSuchElementException
        System.out.println("enlazada.getLast() = " + enlazada.getLast());
        // peekLast() devuelve el último elemento de la lista, si está vacía devuelve null
        System.out.println("enlazada.peekLast() = " + enlazada.peekLast());
        // get(int index) devuelve el elemento de la lista en la posición index
        System.out.println("enlazada.get(3) = " + enlazada.get(3));

        // removeFirst() devuelve y elimina el primer elemento de la lista
        Alumno primero = enlazada.removeFirst();
        System.out.println("\nenlazada.removeFirst() = " + primero);

        // pollFirst() devuelve y elimina el primer elemento de la lista, si está vacía devuelve null
//        System.out.println("enlazada.pollFirst() = " + enlazada.pollFirst());

        // pop() devuelve y elimina el primer elemento de la lista, si está vacía lanza una excepción NoSuchElementException
//        System.out.println("enlazada.pop() = " + enlazada.pop());

        // removeLast() devuelve y elimina el último elemento de la lista
        Alumno ultimo = enlazada.removeLast();
        System.out.println("enlazada.removeLast() = " + ultimo);

        // remove(int index) devuelve y elimina el elemento de la lista en la posición index
        Alumno alumno = enlazada.remove(3);
        System.out.println("enlazada.remove(3) = " + alumno);

        // remove(Object o) devuelve true si el elemento o se encuentra en la lista y lo elimina
        System.out.println("enlazada.remove(new Alumno(\"Zeus\", 2)) = " + enlazada.remove(new Alumno("Zeus", 2)));

        // addLast() añade un elemento al final de la lista
        enlazada.addLast(new Alumno("Goku", 10));

        // set(int index, E element) reemplaza el elemento de la lista en la posición index por element
        enlazada.set(3, new Alumno("Vegeta", 9));

        System.out.println("\nIterando con for");
        enlazada.forEach( a -> System.out.println("\t" + enlazada.indexOf(a) + " : " + a));

        // LISTITERATOR
        // Es un iterador para recorrer una lista
        // Se puede recorrer en ambas direcciones (adelante y atrás)
        // Se puede añadir elementos a la lista mientras se recorre con el iterador

        System.out.println("\n\nLISTITERATOR");
        ListIterator<Alumno> it = enlazada.listIterator();

        // hasNext() devuelve true si hay un elemento siguiente
        System.out.println("Iterando hacia adelante con while e it.hasNext()");
        while (it.hasNext()) {
            Alumno a = it.next();
            System.out.println("\t" + enlazada.indexOf(a) + " : " + a);
        }

        // hasPrevious() devuelve true si hay un elemento anterior
        System.out.println("\nIterando hacia atrás con while e it.hasPrevious()");
        while (it.hasPrevious()) {
            Alumno a = it.previous();
            System.out.println("\t" + enlazada.indexOf(a) + " : " + a);
        }
    }
}
