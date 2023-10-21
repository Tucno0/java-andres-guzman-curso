package org.tucno.colecciones.set;

import java.util.HashSet;
import java.util.Set;

public class _03_HashSetBuscarDuplicado2 {
    public static void main(String[] args) {
        String[] peces = {"Corvina", "Lenguado", "Pejerrey", "Corvina", "Robaldo", "Atún", "Lenguado"};

        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();

        //Agregar los elementos del arreglo al conjunto
        for (String pez : peces) {
            if (!unicos.add(pez)) {
                duplicados.add(pez);
            }
        }

        // Eliminar los duplicados del conjunto de elementos únicos
        // removeAll() recibe como parámetro una colección de elementos, devuelve true si se eliminó al menos un elemento
        unicos.removeAll(duplicados);

        System.out.println(unicos.size() + " elementos únicos: " + unicos);
        System.out.println(duplicados.size() + " elementos duplicados: " + duplicados);
    }
}
