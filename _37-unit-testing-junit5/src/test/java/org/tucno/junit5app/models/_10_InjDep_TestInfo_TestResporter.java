package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class _10_InjDep_TestInfo_TestResporter {
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        System.out.println("Inicializando el método de prueba");
        System.out.println("Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName() + " - " + testInfo.getTags());

        // con publishEntry se puede reportar información sobre la prueba
        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName() + " - " + testInfo.getTags());
    }

    @Test
    @Tag("cuenta")
    @DisplayName("Probando nombre de la cuenta")
    // TestInfo y TestReporter son inyectados por JUnit 5 y se pueden usar para obtener información sobre la prueba
    // TestInfo -> Obtiene información sobre la prueba
    // TestReporter -> Permite reportar información sobre la prueba
    // Tambien se puede inyectar TestInfo y TestReporter en los metodos de inicialización y limpieza (BeforeAll, AfterAll, BeforeEach, AfterEach)
    // Para hacerlo una sola vez, se debe usar la anotación @TestInstance

//    void testNombreCuenta(TestInfo testInfo, TestReporter testReporter) {
    void testNombreCuenta() {
        System.out.println("Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName() + " - " + testInfo.getTags());

        if (testInfo.getTags().contains("cuenta")) {
            // Se puede usar TestReporter para reportar información sobre la prueba
            testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() + " - " + testInfo.getTestMethod().orElse(null).getName() + " - " + testInfo.getTags());
        }

        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("1000.12345"));
        String esperado = "John Doe";
        String real = cuenta.getPersona();

        assertNotNull(real, "La cuenta no puede ser nula"); // assertNotNull verifica que el valor no sea nulo
        assertEquals(esperado, real, () -> "El nombre de la cuenta no es el esperado, se esperaba: " + esperado + " y se obtuvo: " + real);
        assertTrue(real.equals("John Doe"), () -> "El nombre de la cuenta debe ser John Doe");
    }
}
