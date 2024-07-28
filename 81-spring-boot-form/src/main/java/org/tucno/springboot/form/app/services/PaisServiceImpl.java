package org.tucno.springboot.form.app.services;

import org.springframework.stereotype.Service;
import org.tucno.springboot.form.app.models.domain.Pais;

import java.util.Arrays;
import java.util.List;

// Se crea un servicio para obtener la lista de países
@Service
public class PaisServiceImpl implements PaisService {
    private List<Pais> paises;

    public PaisServiceImpl() {
        this.paises = Arrays.asList(
            new Pais(1, "ES", "España"),
            new Pais(2, "MX", "México"),
            new Pais(3, "CL", "Chile"),
            new Pais(4, "AR", "Argentina"),
            new Pais(5, "PE", "Perú"),
            new Pais(6, "CO", "Colombia"),
            new Pais(7, "VE", "Venezuela")
        );
    }

    @Override
    public List<Pais> listar() {
        return paises;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for (Pais pais : paises) {
            if (id == pais.getId()) {
                resultado = pais;
                break;
            }
        }
        return resultado;
    }
}
