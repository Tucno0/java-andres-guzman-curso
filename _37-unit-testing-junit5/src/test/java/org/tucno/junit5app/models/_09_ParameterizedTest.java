package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class _09_ParameterizedTest {
    Cuenta cuenta;

    @BeforeEach
    // Se ejecuta antes de cada prueba
    void initMetodoTest() {
        this.cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
    }

    // Tag permite agrupar pruebas bajo un mismo nombre
    // Sirve para filtrar pruebas y ejecutar solo las que tengan un tag específico
    @Tag("param")
    class PruebasParametrizadasTest {
        @DisplayName("Probando debito en la cuenta - ValueSource")
        // ParametrizedTest permite ejecutar una prueba con diferentes valores
        @ParameterizedTest(name = "Cuenta con saldo {0} - Monto a debitar {1}")
        // ValueSource permite pasar un conjunto de valores a la prueba
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
        void testDebitoCuentaValueSource(String monto) { // Se recibe el valor del ValueSource en el método, en cada iteración se recibe un valor diferente
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo()); // debe ser diferente de nulo
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0); // que el saldo sea mayor a cero
        }

        @DisplayName("Probando debito en la cuenta - CSV")
        @ParameterizedTest(name = "Cuenta con saldo {0} - Monto a debitar {1} - Saldo esperado {2}")
        // CsvSource permite pasar un conjunto de valores a la prueba, a diferencia de ValueSource, CsvSource permite pasar más de un valor por iteración
        @CsvSource({"1, 1000, 100, 900", "2, 1000, 200, 800", "3, 1000, 300, 700", "4, 1000, 500, 500", "5, 1000, 700, 300", "6, 1000, 1000, 0"})
        void testDebitoCuentaCsv(String index, String saldo, String monto, String saldoEsperado) {
            System.out.println(index + " -> " + saldo + " - " + monto + " - " + saldoEsperado);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));

            assertEquals(saldoEsperado, cuenta.getSaldo().toPlainString()); // se verifica que el saldo sea igual al saldo esperado
        }

        @DisplayName("Probando debito en la cuenta - ValueSource")
        // ParametrizedTest permite ejecutar una prueba con diferentes valores
        @ParameterizedTest(name = "Cuenta con saldo {0} - Monto a debitar {1}")
        // ValueSource permite pasar un conjunto de valores a la prueba
        @CsvFileSource(resources = "/data.csv")
            // Se puede pasar un archivo CSV con los valores
        void testDebitoCuentaCsvFileSource(String monto) {
            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo()); // debe ser diferente de nulo
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0); // que el saldo sea mayor a cero
        }
    }

    @Tag("param")
    @DisplayName("Probando debito en la cuenta - MethodSource")
    @ParameterizedTest(name = "Cuenta con saldo {0} - Monto a debitar {1}")
    // MethodSource permite pasar un conjunto de valores a la prueba desde un método (montoList)
    @MethodSource("montoList")
        // Se pasa el nombre del método que contiene los valores
    void testDebitoCuentaMethodSource(String monto) {
        cuenta.debito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo()); // debe ser diferente de nulo
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0); // que el saldo sea mayor a cero
    }

    static List<String> montoList() {
        return List.of("100", "200", "300", "500", "700", "1000");
    }
}
