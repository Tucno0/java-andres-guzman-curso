package org.tucno.appfacturas;

import org.tucno.appfacturas.modelo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setRuc("12345678-9");
        cliente.setNombre("Juan");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese la descripción de la factura: ");
        String descripcion = s.nextLine();

        Factura factura = new Factura(descripcion, cliente);

        Producto producto;
        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese el nombre del producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio del producto: ");
            producto.setPrecio(s.nextDouble());

            System.out.print("Ingrese la cantidad del producto: ");
            factura.addItemFactura( new ItemFactura(s.nextInt(), producto) );

            System.out.println();
            s.nextLine();
        }

        System.out.println(factura);
    }
}
