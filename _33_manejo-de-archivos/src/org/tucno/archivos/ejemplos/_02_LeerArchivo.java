package org.tucno.archivos.ejemplos;

import org.tucno.archivos.ejemplos.service.ArchivoServicio;

public class _02_LeerArchivo {
    public static void main(String[] args) {
        ArchivoServicio service = new ArchivoServicio();

        System.out.println(service.leerArchivo2("D:\\Cursos\\Andres Guzman\\Java\\_33_manejo-de-archivos\\src\\org\\tucno\\archivos\\ejemplos\\files\\archivo.txt"));
    }
}
