package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class _08_RepeatedTest {

    // RepeatedTest se usa para repetir una prueba un número específico de veces
    // Util cuando se necesita probar un comportamiento repetitivo o aleatorio
    @DisplayName("Probando debito en la cuenta")
    @RepeatedTest(value = 5, name = "{displayName} -> La cuenta se ha recargado {currentRepetition} veces con {totalRepetitions}")
    void testDebitoCuenta(RepetitionInfo info) { // RepetitionInfo se usa para obtener información sobre la repetición actual
        if (info.getCurrentRepetition() == 3) {
            System.out.println("Estamos en la repetición " + info.getCurrentRepetition());
        }

        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo()); // debe ser diferente de nulo
        assertEquals(900, cuenta.getSaldo().intValue()); // debe ser igual a 900 porque se le restó 100 con debito()
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }
}
