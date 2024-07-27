package org.tucno.springboot.di.app.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

// Tambien las clases POJOs pueden ser componentes de Spring
@Component
// El alcance de la factura es por peticion
@RequestScope
public class Factura {

    @Value("${factura.descripcion}")
    private String descripcion;

    // El cliente es un componente de Spring
    @Autowired
    private Cliente cliente;

    @Autowired
//    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    // El metodo se ejecuta despues de que el objeto es creado e inyectado por Spring y antes de que el objeto sea devuelto al contenedor de Spring
    @PostConstruct
    public void inicializar() {
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }

    @PreDestroy
    public void destruir() {
        System.out.println("Factura destruida: ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
