package org.tucno.pooherencia;

public class Persona { // Implícitamente la clase Persona también hereda de la clase Object
    /**
     * Modificadores de acceso:
     * - public: se puede acceder desde cualquier clase
     * - protected: se puede acceder desde la misma clase y desde las clases hijas - Tambien se puede acceder desde las clases del mismo paquete
     * - private: se puede acceder sólo desde la misma clase
     * - default: se puede acceder desde la misma clase y desde las clases del mismo paquete
     */
    private String nombre;
    private String apellido;
    private int edad;
    private String email;

    // Constructor por defecto
    public Persona() {
        System.out.println("Persona: Inicializando constructor");
    }

    // Constructor con parámetros
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido, int edad) {
        this(nombre, apellido);
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos
    public String saludar() {
        return "Hola que tal";
    }

    // Sobreescritura de métodos
    @Override
    public String toString() {
        return  "\nnombre = '" + nombre +
                "\napellido = '" + apellido +
                "\nedad = " + edad +
                "\nemail = '" + email +
                "\nsaludo = '" + saludar();

    }
}
