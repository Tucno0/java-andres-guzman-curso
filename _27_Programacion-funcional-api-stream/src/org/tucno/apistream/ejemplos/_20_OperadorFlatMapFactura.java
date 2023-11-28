package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Factura;
import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class _20_OperadorFlatMapFactura {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Raúl", "López");
        Usuario usuario2 = new Usuario("Víctor", "García");

        usuario1.addFactura(new Factura("Compra de celular"));
        usuario1.addFactura(new Factura("Compra de laptop"));

        usuario2.addFactura(new Factura("Compra de bicicleta"));
        usuario2.addFactura(new Factura("Compra de patineta"));

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        // Imprimir usuarios y facturas con forEach()
        usuarios.forEach(usuario -> {
            System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
            usuario.getFacturas().forEach(factura -> {
                System.out.println("Factura: " + factura.getDescripcion());
            });
        });

        System.out.println("\n--------------------------------------------------\n");

        // Imprimir usuarios y facturas con flatMap()
        usuarios.stream()
                .flatMap(usuario -> usuario.getFacturas().stream())
                .forEach(factura -> {
                    System.out.println("Factura: " + factura.getDescripcion().concat(" - ").concat(factura.getUsuario().toString()));
                });
    }
}
