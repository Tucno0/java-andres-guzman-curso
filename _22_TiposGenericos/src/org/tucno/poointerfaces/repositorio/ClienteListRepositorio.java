package org.tucno.poointerfaces.repositorio;

import org.tucno.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{
    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return this.dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;

        for (Cliente cli : this.dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }

        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id)); // this.dataSource.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        // Class anónima
        listaOrdenada.sort((o1, o2) -> {
            int resultado = 0;

            if (dir == Direccion.ASC) {
                resultado = OrdenableRepositorio.ordenar(campo, o1, o2);
            } else if (dir == Direccion.DESC) {
                resultado = OrdenableRepositorio.ordenar(campo, o2, o1);
            }
            return resultado;
        });

        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return this.dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
