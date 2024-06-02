package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _01_FetchLazyOneToMany {
    public static void main(String[] args) {
        // FETCH LAZY
        // El atributo fetch de la anotación @OneToMany se utiliza para indicar cómo se cargarán los datos de la relación.
        // Si el atributo fetch se establece en FetchType.LAZY, los datos de la relación se cargarán solo cuando se acceda a la colección.
        EntityManager entityManager = JpaUtil.getEntityManager();

        Cliente cliente = entityManager.find(Cliente.class, 1L);

        // Solo se carga la colección de direcciones cuando se accede a ella, en este caso al imprimir el cliente
        System.out.println(cliente);

        entityManager.close();
    }
}
