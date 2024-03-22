package org.tucno.junit5app.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.tucno.junit5app.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class _01_CuentaTest {
    @Test
    @Tag("cuenta")
    @DisplayName("Probando nombre de la cuenta")
    void testNombreCuenta() {
        // Arrange => Preparar
        // En Arrange se prepara el entorno de la prueba
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));

        // Act => Actuar
        // En Act se ejecuta el código que se va a probar
        String esperado = "John Doe";
        String real = cuenta.getPersona();

        // Assert
        // En Assert se verifica que el resultado sea el esperado
        // Con los metodos estaticos de la clase Assertions se pueden hacer las comparaciones
        assertNotNull(real, "La cuenta no puede ser nula"); // assertNotNull verifica que el valor no sea nulo

        // assertEquals verifica que el valor sea igual al esperado
        // El mensaje que se encuentra dentro de la expresión lambda se ejecuta solo si la prueba falla, esto se hace para no ejecutar el mensaje si la prueba es exitosa
        assertEquals(esperado, real, () -> "El nombre de la cuenta no es el esperado, se esperaba: " + esperado + " y se obtuvo: " + real);
        // assertTrue verifica que el valor sea verdadero
        assertTrue(real.equals("John Doe"), () -> "El nombre de la cuenta debe ser John Doe");
    }

    @Test
    @Tag("cuenta")
    @DisplayName("Probando el saldo de la cuenta")
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue()); // doubleValue() convierte el valor BigDecimal a double
        assertEquals("1000.12345", cuenta.getSaldo().toPlainString()); // toPlainString() convierte el valor BigDecimal a String
        // compareTo() compara dos valores y devuelve 0 si son iguales, 1 si el valor es mayor y -1 si el valor es menor
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); // que el saldo sea mayor o igual a cero
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0); // que el saldo sea mayor a cero
    }

    @Test
    @Tag("cuenta")
    @DisplayName("Probando debito en la cuenta")
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("1000.12345"));

//        assertNotEquals(cuenta, cuenta2); // verifica que los objetos sean diferentes
        assertEquals(cuenta2, cuenta); // verifica que los objetos sean iguales
    }

    @Test
    @Tag("cuenta")
    @DisplayName("Probando debito en la cuenta")
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo()); // debe ser diferente de nulo
        assertEquals(900, cuenta.getSaldo().intValue()); // debe ser igual a 900 porque se le restó 100 con debito()
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    @Tag("cuenta")
    @DisplayName("Probando credito en la cuenta 🍗🥩")
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo()); // debe ser diferente de nulo
        assertEquals(1100, cuenta.getSaldo().intValue()); // debe ser igual a 1100 porque se le sumó 100 con credito()
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    @Tag("error")
    @DisplayName("Probando debito en la cuenta con assertThrows")
    void testDineroInsuficienteException() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));

        // assertThrows() verifica que se lance una excepción de tipo DineroInsuficienteException
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });

        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente en la cuenta";

        assertEquals(esperado, actual);
    }
}