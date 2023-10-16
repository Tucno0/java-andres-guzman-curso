package org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio;


import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.EscrituraAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.LecturaAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.RegistroDuplicadoAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{
    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    // También se tiene que poner en la interfaz OrdenablePaginableCrudRepositorio y en la interfaz CrudRepositorio
    // Se puede implementar el error hijo aquí y en la interfaz CrudRepositorio implementar el error padre (AccesoDatoException)
    // También opcionalmente podemos no implementar el error hijo aquí
    public T porId(Integer id) throws LecturaAccesoDatoException{
        // Si id es null o id es menor que cero, lanzamos una excepción
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("El id no puede ser nulo o menor que cero");
        }
        T resultado = null;

        for (T cli : this.dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }

        // Si resultado es null, lanzamos una excepción
        if (resultado == null) {
            throw new LecturaAccesoDatoException("No existe el registro con el id: " + id);
        }

        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        // Si t es null, lanzamos una excepción
        if (t == null) {
            throw new EscrituraAccesoDatoException("No se puede insertar un objeto nulo");
        }

        // Si hay usuario duplicado, lanzamos una excepción
        if (this.dataSource.contains(t)) {
            throw new RegistroDuplicadoAccesoDatoException("Ya existe cliente registro con el id: " + t.getId());
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id)); // this.dataSource.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return this.dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
