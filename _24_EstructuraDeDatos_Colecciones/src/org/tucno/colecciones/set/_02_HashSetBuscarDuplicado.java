package org.tucno.colecciones.set;

import java.util.HashSet;
import java.util.Set;

public class _02_HashSetBuscarDuplicado {
    public static void main(String[] args) {
        String[] peces = {"Corvina", "Lenguado", "Pejerrey", "Corvina", "Robaldo", "Atún", "Lenguado"};

        Set<String> unicos = new HashSet<>();

        //Agregar los elementos del arreglo al conjunto
        for (String pez : peces) {
            if (!unicos.add(pez)) {
                System.out.println("Elemento duplicado: " + pez);
            }
        }

        System.out.println(unicos.size() + " elementos únicos: " + unicos);
    }
}
