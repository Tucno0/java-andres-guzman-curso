package org.tucno.pooclasesabstractas.form;

import org.tucno.pooclasesabstractas.form.elementos.*;
import org.tucno.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.Arrays;
import java.util.List;

public class _02_FormClasesAnonimas {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addOpcion(new Opcion("1", "Java"))
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected())
                .addOpcion(new Opcion("5", "PHP"));

        // Clases anónimas
        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name=\"" + this.nombre + "\" value=\"" + this.valor + "\">";
            }
        };

        // Asignamos valores a los atributos
        saludar.setValor("Hola qué tal, este campo está deshabilitado!");
        username.setValor("John Doe");
        password.setValor("12345");
        email.setValor("john.doe@correo.com");
        edad.setValor("30");

        experiencia.setValor("... más de 10 años de experiencia ...");

//        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        // Dibujamos cada elemento usando expresiones lambda (Stream API)
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

    }
}
