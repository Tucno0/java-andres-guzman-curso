package org.tucno.pooclasesabstractas.form;

import org.tucno.pooclasesabstractas.form.elementos.*;
import org.tucno.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_EjemploForm {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        username.setValor("John Doe");
        password.setValor("12345");
        email.setValor("john.doe@correo.com");
        edad.setValor("30");

        experiencia.setValor("... más de 10 años de experiencia ...");

        java.setSelected(true);

        // Creamos una lista de elementos de formulario
//        List<ElementoForm> elementos = new ArrayList<>();
//        elementos.add(username);
//        elementos.add(password);
//        elementos.add(email);
//        elementos.add(edad);
//        elementos.add(experiencia);
//        elementos.add(lenguaje);

        // Otra forma utilizando Arrays.asList
        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje);

        // Dibujamos cada elemento usando expresiones lambda (Stream API)
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        // Dibujamos cada elemento usando un bucle for
//        for (ElementoForm elemento : elementos) {
//            System.out.println(elemento.dibujarHtml());
//            System.out.println("<br>");
//        }
    }
}
