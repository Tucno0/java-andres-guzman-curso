package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class _06_Assumptions {
    Cuenta cuenta1;
    Cuenta cuenta2;

    @BeforeEach
        // Se ejecuta antes de cada prueba
    void initMetodoTest() {
        this.cuenta1 = new Cuenta("John Doe", new BigDecimal("1000"));
        this.cuenta2 = new Cuenta("Jane Doe", new BigDecimal("2000"));
        System.out.println("Inicializando el método de prueba");
    }

    @AfterEach
        // Se ejecuta después de cada prueba
    void tearDown() {
        System.out.println("Finalizando el método de prueba");
    }

    //=============== 379. Ejecución de test condicional con Assumptions programáticamente ===============
    @Test
    @DisplayName("Probando que se realice la transferencia entre cuentas - DEV")
    void testTransferirDineroCuentasDev() {
        // Se puede usar Assumptions para condicionar la ejecución de una prueba en base a una condición
        boolean esDev = "dev".equals(System.getProperty("ENV")); // Se obtiene la variable de entorno ENV y se compara con dev

        // Si esDev es falso, la prueba no se ejecuta
        assumeTrue(esDev); // Se asume que es verdadero

        Banco banco = new Banco();
        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta1, cuenta2, new BigDecimal(500));

        assertEquals("500", this.cuenta1.getSaldo().toPlainString());
        assertEquals("2500", this.cuenta2.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("Test Saldo Cuenta - DEV2")
    void testTransferirDineroCuentasDev2() {
        // Se puede usar Assumptions para condicionar la ejecución de una prueba en base a una condición
        boolean esDev = "dev".equals(System.getProperty("ENV")); // Se obtiene la variable de entorno ENV y se compara con dev

        // Si esDev es falso, la prueba no se ejecuta
        // Se ejecuta las pruebas dentro de la expresión lambda si es verdadero
        assumingThat(esDev, () -> {
            Banco banco = new Banco();
            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta1, cuenta2, new BigDecimal(500));

            assertEquals("500", this.cuenta1.getSaldo().toPlainString());
        });

        // Pero se ejecuta esta prueba siempre
        assertEquals("2500", this.cuenta2.getSaldo().toPlainString());
    }
}
