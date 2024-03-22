package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

// Se ejecuta una sola instancia de la clase, por defecto es por cada método
// Cuando es por clase, se ejecuta una sola instancia de la clase, por lo que se pueden compartir datos entre los métodos
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class _02_BancoTest {
    Cuenta cuenta1;
    Cuenta cuenta2;

    @BeforeEach // Se ejecuta antes de cada prueba
    void initMetodoTest() {
        this.cuenta1 = new Cuenta("John Doe", new BigDecimal("1000"));
        this.cuenta2 = new Cuenta("Jane Doe", new BigDecimal("2000"));
        System.out.println("Inicializando el método de prueba");
    }

    @AfterEach // Se ejecuta después de cada prueba
    void tearDown() {
        System.out.println("Finalizando el método de prueba");
    }

    @BeforeAll // Se ejecuta antes de todas las pruebas
    // Es importante que el método sea estático, porque se ejecuta antes de que se cree una instancia de la clase
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll // Se ejecuta después de todas las pruebas
    // Es importante que el método sea estático, porque se ejecuta antes de que se cree una instancia de la clase
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @Tag("cuenta")
    @Test
    @DisplayName("Probando que se realice la transferencia entre cuentas")
    void testTransferirDineroCuentas() {
        Banco banco = new Banco();
        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta1, cuenta2, new BigDecimal(500));

        assertEquals("500", this.cuenta1.getSaldo().toPlainString());
        assertEquals("2500", this.cuenta2.getSaldo().toPlainString());
    }

    @Tag("cuenta")
    @Tag("banco")
    @Test
//    @Disabled // Deshabilita la prueba para que no se ejecute
    @DisplayName("Probando relaciones entre cuentas y banco con assertAll")
    void testRelacionBancoCuentas() {
//        fail(); // Forzar un error para ver el mensaje de error

        Banco banco = new Banco();
        banco.addCuenta(this.cuenta1);
        banco.addCuenta(this.cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(this.cuenta1, this.cuenta2, new BigDecimal(500));

        // Assert all verifica que todas las condiciones sean verdaderas
        assertAll(
            () -> assertEquals(
                "500",
                this.cuenta1.getSaldo().toPlainString(),
                () -> "El saldo de la cuenta 1 no es el esperado, se esperaba: 500 y se obtuvo: " + this.cuenta1.getSaldo()
            ),
            () -> assertEquals("2500", this.cuenta2.getSaldo().toPlainString()),
            () -> assertEquals(2, banco.getCuentas().size()), // verifica que el banco tenga dos cuentas en la lista
            () -> assertEquals("Banco del Estado", this.cuenta1.getBanco().getNombre()), // verifica que el nombre del banco sea el mismo
            () -> assertEquals("John Doe", banco.getCuentas().stream() // verifica que el nombre de la persona sea el mismo
                    .filter(c -> c.getPersona().equals("John Doe"))
                    .findFirst()
                    .get()
                    .getPersona()
            ),
            () -> assertTrue( banco.getCuentas().stream().anyMatch(c -> c.getPersona().equals("Jane Doe")) ) // verifica que el nombre de la persona sea el mismo
        );
    }
}


























