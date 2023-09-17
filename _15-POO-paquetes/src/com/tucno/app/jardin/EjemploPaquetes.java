package com.tucno.app.jardin;

// Importando las clases Persona y Perro
    //  import com.tucno.app.hogar.Gato;
    //  import com.tucno.app.hogar.Persona;

    import com.tucno.app.hogar.*; // Importa todas las clases del paquete

// Importando el metodo estatico saludar de la clase Persona
    //  import static com.tucno.app.hogar.Persona.saludar;
    //  import static com.tucno.app.hogar.Persona.GENERO_MASCULINO;
    //  import static com.tucno.app.hogar.Persona.GENERO_FEMENINO;
    import static com.tucno.app.hogar.Persona.*; // Importa todos los metodos estaticos de la clase Persona

// Importando el enumerado ColorPelo
    import static com.tucno.app.hogar.ColorPelo.*; // Importa todos los enumerados de la clase ColorPelo

public class EjemploPaquetes {
    public static void main(String[] args) {

        // Primer forma de importar una clase
//        com.tucno.app.hogar.Persona persona = new com.tucno.app.hogar.Persona();

        // Segunda forma de importar una clase
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setColorPelo(CAFE);
        System.out.println(persona.getNombre());

        Perro perro = new Perro();
        perro.nombre = "Firulais";
        perro.raza = "Bulldog";

        String jugada = perro.jugar(persona);
        System.out.println("jugada = " + jugada);

        String saludo = saludar();
        System.out.println("saludo = " + saludo);

        String generoM = GENERO_MASCULINO;
        String generoF = GENERO_FEMENINO;

        System.out.println("generoM = " + generoM);
        System.out.println("generoF = " + generoF);
    }
}
