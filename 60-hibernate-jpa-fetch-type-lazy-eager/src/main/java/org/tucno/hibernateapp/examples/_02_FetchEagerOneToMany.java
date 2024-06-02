package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _02_FetchEagerOneToMany {
    public static void main(String[] args) {
        // FETCH EAGER
        // el atributo fetch de la anotación @OneToMany se utiliza para indicar si se carga la colección de forma perezosa o ansiosa
        // Si el atributo fetch se establece en FetchType.EAGER, los datos de la relación se cargarán de inmediato.
        EntityManager entityManager = JpaUtil.getEntityManager();

        Cliente cliente = entityManager.find(Cliente.class, 1L);

        entityManager.close();
    }
}
