package org.tucno.springboot.di.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.tucno.springboot.di.app.models.domain.ItemFactura;
import org.tucno.springboot.di.app.models.domain.Producto;
import org.tucno.springboot.di.app.models.service.IServicio;
import org.tucno.springboot.di.app.models.service.MiServicio;
import org.tucno.springboot.di.app.models.service.MiServicioComplejo;

import java.util.Arrays;
import java.util.List;

// La anotación @Configuration se utiliza para indicar que la clase es una clase de configuración de Spring y que se deben buscar los beans definidos en la clase
@Configuration
public class AppConfig {

    // La anotación @Bean se utiliza para indicar que el método devuelve un bean de Spring que se debe registrar en el contenedor de Spring
    @Bean("miServicioSimple")
    @Primary
    public IServicio registrarMiServicio() {
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
//    @Primary
    public IServicio registrarMiServicioComplejo() {
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems() {
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);
        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);

        return Arrays.asList(linea1, linea2);
    }

    @Bean("itemsFacturaOficina")
    @Primary
    public List<ItemFactura> registrarItemsOficina() {
        Producto producto1 = new Producto("Monitor LG LCD 24", 250);
        Producto producto2 = new Producto("Notebook Asus", 500);
        Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
        Producto producto4 = new Producto("Escritorio Oficina", 300);
        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 3);
        ItemFactura linea3 = new ItemFactura(producto3, 4);
        ItemFactura linea4 = new ItemFactura(producto4, 5);

        return Arrays.asList(linea1, linea2, linea3, linea4);
    }
}
