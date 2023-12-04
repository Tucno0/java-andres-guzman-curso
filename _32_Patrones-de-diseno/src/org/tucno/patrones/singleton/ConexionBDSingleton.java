package org.tucno.patrones.singleton;

// PATRON DE DISEÑO SINGLETON
// Este patrón de diseño se utiliza cuando se necesita una única instancia de una clase.

// Por ejemplo, cuando se necesita una única conexión a una base de datos.
// En este caso, se crea una clase que se encarga de crear una única instancia de la clase que se necesita.
// Esta clase se llama clase Singleton.
// La clase Singleton tiene un método que devuelve la instancia de la clase que se necesita.
// Si la instancia no existe, la crea y la devuelve.
// El constructor de la clase Singleton es privado, para que no se pueda crear una instancia de la clase Singleton desde fuera de la clase.
public class ConexionBDSingleton {
    private static ConexionBDSingleton instancia; // Atributo de clase que almacena la única instancia de la clase

    private ConexionBDSingleton() { // Constructor privado para que no se pueda crear una instancia de la clase desde fuera de la clase
        System.out.println("Conectando con la base de datos...");
    }

    public static ConexionBDSingleton getInstancia() { // Método que devuelve la única instancia de la clase
        if (instancia == null) { // Si la instancia no existe, la crea
            instancia = new ConexionBDSingleton();
        }
        return instancia; // si no, devuelve la instancia que ya existe
    }
}
