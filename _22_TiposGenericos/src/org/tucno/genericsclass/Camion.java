package org.tucno.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Clase que representa un camion que puede transportar objetos de cualquier tipo
 * @param <T> Tipo de objeto que puede transportar el camion
 */
public class Camion<T> implements Iterable<T>{
    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void add(T objeto) {
        if (this.objetos.size() <= this.max)
            this.objetos.add(objeto);
        else
            throw new RuntimeException("No hay mas espacio en el camion");
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }

}
