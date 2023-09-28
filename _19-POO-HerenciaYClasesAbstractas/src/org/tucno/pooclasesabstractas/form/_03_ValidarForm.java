package org.tucno.pooclasesabstractas.form;

import org.tucno.pooclasesabstractas.form.elementos.ElementoForm;
import org.tucno.pooclasesabstractas.form.elementos.InputForm;
import org.tucno.pooclasesabstractas.form.elementos.SelectForm;
import org.tucno.pooclasesabstractas.form.elementos.TextareaForm;
import org.tucno.pooclasesabstractas.form.elementos.select.Opcion;
import org.tucno.pooclasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class _03_ValidarForm {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
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
        username.setValor("");
        password.setValor("12345");
        email.setValor("john.doecorreo.com");
        edad.setValor("-2");

        experiencia.setValor("... más de 10 años de experiencia ...");

//        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        // Dibujamos cada elemento usando expresiones lambda (Stream API)
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        // Validamos cada elemento usando expresiones lambda (Stream API)
        elementos.forEach(e -> {
            if (!e.esValido()) {
                e.getErrores().forEach(System.out::println); // err -> System.out.println(err) Method Reference
//                e.getErrores().forEach( err -> System.out.println(e.getNombre() + ": " + err));
            }
        });
    }
}
