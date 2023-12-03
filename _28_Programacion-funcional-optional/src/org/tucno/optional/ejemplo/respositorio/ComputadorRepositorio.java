package org.tucno.optional.ejemplo.respositorio;

import org.tucno.optional.ejemplo.models.Computador;
import org.tucno.optional.ejemplo.models.Fabricante;
import org.tucno.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador> {
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();

        Procesador procesadorIntel = new Procesador("Intel Core i7", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G15");
        asus.setProcesador(procesadorIntel);

        dataSource.add(asus);
        dataSource.add(new Computador("MacBook Pro", "M1"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                .filter(computador -> computador.getNombre().equalsIgnoreCase(nombre)).findFirst();
//        for (Computador computador : dataSource) { // for-each loop
//            if (computador.getNombre().equalsIgnoreCase(nombre)) {
//                return Optional.of(computador);
//            }
//        }
//        return Optional.empty();
    }
}
