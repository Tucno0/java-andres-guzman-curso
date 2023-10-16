package org.tucno.tarea26;

import java.util.List;

public class Main {

    public static <P> void imprimirBolsa(List<P> productos) {
        productos.forEach(producto -> {
            if (producto instanceof Fruta) {
                Fruta fruta = (Fruta) producto;
                System.out.println("Nombre del Producto: " + fruta.getNombre() +
                        "\nPrecio: " + fruta.getPrecio() +
                        "\nPeso: " + fruta.getPeso() +
                        "\nColor: " + fruta.getColor() + "\n");

            } else if (producto instanceof Lacteo) {
                Lacteo lacteo = (Lacteo) producto;
                System.out.println("Nombre del Producto: " + lacteo.getNombre() +
                        "\nPrecio: " + lacteo.getPrecio() +
                        "\nCantidad: " + lacteo.getCantidad() +
                        "\nProteinas: " + lacteo.getProteinas() + "\n");

            } else if (producto instanceof Limpieza) {
                Limpieza limpieza = (Limpieza) producto;
                System.out.println("Nombre del Producto: " + limpieza.getNombre() +
                        "\nPrecio: " + limpieza.getPrecio() +
                        "\nComponentes: " + limpieza.getComponentes() +
                        "\nLitros: " + limpieza.getLitros() + "\n");

            } else if (producto instanceof NoPerecible) {
                NoPerecible noPerecible = (NoPerecible) producto;
                System.out.println("Nombre del Producto: " + noPerecible.getNombre() +
                        "\nPrecio: " + noPerecible.getPrecio() +
                        "\nContenido: " + noPerecible.getContenido() +
                        "\nCalorias: " + noPerecible.getCalorias() + "\n");
            }
        });
    }
    public static void main(String[] args) {
        BolsaSupermercado<Lacteo> lacteos = new BolsaSupermercado<Lacteo>(3);
        lacteos.addProducto(new Lacteo("Leche", 1.5, 1, 3))
                .addProducto(new Lacteo("Yogur", 0.5, 1, 2))
                .addProducto(new Lacteo("Queso", 2.5, 1, 5));
        imprimirBolsa(lacteos.getProductos());

        BolsaSupermercado<Fruta> frutas = new BolsaSupermercado<Fruta>(3);
        frutas.addProducto(new Fruta("Manzana", 0.5, 1, "Rojo"))
                .addProducto(new Fruta("Platano", 0.5, 1, "Amarillo"))
                .addProducto(new Fruta("Naranja", 0.5, 1, "Naranja"));
        imprimirBolsa(frutas.getProductos());

        BolsaSupermercado<Limpieza> limpieza = new BolsaSupermercado<Limpieza>(3);
        limpieza.addProducto(new Limpieza("Detergente", 2.5, "Detergente", 1))
                .addProducto(new Limpieza("Suavizante", 2.5, "Suavizante", 1))
                .addProducto(new Limpieza("Lejia", 2.5, "Lejia", 1));
        imprimirBolsa(limpieza.getProductos());

        BolsaSupermercado<NoPerecible> noPerecibles = new BolsaSupermercado<NoPerecible>(3);
        noPerecibles.addProducto(new NoPerecible("Arroz", 1.5, 1, 3))
                .addProducto(new NoPerecible("Pasta", 0.5, 1, 2))
                .addProducto(new NoPerecible("Legumbres", 2.5, 1, 5));
        imprimirBolsa(noPerecibles.getProductos());
    }
}
