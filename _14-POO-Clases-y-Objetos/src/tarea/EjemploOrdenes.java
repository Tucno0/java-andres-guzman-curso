package tarea;

import java.util.Scanner;

public class EjemploOrdenes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Orden de compra 1
        Cliente cliente1 = new Cliente("Juan", "Pérez");
        OrdenCompra orden1 = new OrdenCompra("Compra de muebles");
        orden1.setCliente(cliente1);

        System.out.println("Ingrese los productos de la orden 1");
        boolean duplicado;
        String nombre;
        String fabricante;
        int precio;

        System.out.println("Ingrese 4 productos");
        for ( int i = 0; i < orden1.getProductos().length; i++ ) {
            do {
                System.out.print("\nIngrese el nombre del producto " + (i + 1) + ": ");
                nombre = entrada.next();
                System.out.print("Ingrese el fabricante del producto " + (i + 1) + ": ");
                fabricante = entrada.next();
                System.out.print("Ingrese el precio del producto " + (i + 1) + ": ");
                precio = entrada.nextInt();

                duplicado = orden1.addProducto(new Producto(fabricante, nombre, precio));
            } while (duplicado);
        }

        orden1.verDetalle();

        // Orden de compra 2

        // Orden de compra 3
    }
}
