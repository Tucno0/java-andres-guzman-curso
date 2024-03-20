package org.tucno.archivos.ejemplos;

import org.tucno.archivos.ejemplos.service.ArchivoServicio;

public class _01_CrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "D:\\Cursos\\Andres Guzman\\Java\\_33_manejo-de-archivos\\src\\org\\tucno\\archivos\\ejemplos\\files\\archivo.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo3(nombreArchivo);
    }
}
