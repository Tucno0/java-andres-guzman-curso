package org.tucno.archivos.ejemplos.service;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {

    // Método para crear un archivo en la ruta que le pasamos como parámetro con BufferedWriter
    public  void crearArchivo(String nombre) {
        // File nos permite crear un archivo en la ruta que le pasamos como parámetro
        File archivo = new File(nombre);

        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))){
            // FileWriter nos permite escribir en el archivo que le pasamos como parámetro
            // true: nos permite agregar texto al archivo sin sobreescribirlo
//            FileWriter escritor = new FileWriter(archivo, true);

            // BufferedWriter nos permite escribir en el archivo que le pasamos como parámetro
            // sin necesidad de hacerlo línea por línea (append)
            // Es mas eficiente que FileWriter
//            BufferedWriter buffer = new BufferedWriter(escritor);
            // Con append() podemos agregar texto al archivo sin sobreescribirlo

            buffer.append("Hola que tal amigos\n")
                    .append("Todo bien?\n")
                    .append("Nos vemos luego\n");
//            buffer.close();
            System.out.println("Archivo creado correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para crear un archivo en la ruta que le pasamos como parámetro con PrintWriter
    public  void crearArchivo2(String nombre) {
        // File nos permite crear un archivo en la ruta que le pasamos como parámetro
        File archivo = new File(nombre);

        try(PrintWriter print = new PrintWriter(new FileWriter(archivo, true))){
            // PrintWriter nos permite escribir en el archivo como en el terminal
            print.println("Hola que tal amigos");
            print.println("Todo bien?");
            print.printf("Nos vemos luego %s", "amigos");

            System.out.println("Archivo creado correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para leer un archivo en la ruta que le pasamos como parámetro con BufferedReader
    public String leerArchivo(String nombre) {
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = reader.readLine()) != null) {
                sb.append(linea).append("\n");
            }
            reader.close(); // Cerramos el archivo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    // Método para leer un archivo en la ruta que le pasamos como parámetro con Scanner
    public String leerArchivo2(String nombre) {
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try {
            Scanner reader = new Scanner(archivo);
            reader.useDelimiter("\n");
            while (reader.hasNext()) {
                sb.append(reader.nextLine()).append("\n");
            }
            reader.close(); // Cerramos el archivo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
