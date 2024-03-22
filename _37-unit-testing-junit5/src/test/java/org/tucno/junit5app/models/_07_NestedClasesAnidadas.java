package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

public class _07_NestedClasesAnidadas {
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

    @Nested
    @DisplayName("Tests relacionados con el SO")
    class SistemaOperativoTest {
        @Test
        @DisplayName("Probando test solo en Windows")
        @EnabledOnOs(OS.WINDOWS) // Habilita la prueba solo en Windows
        void testSoloWindows() {
            System.out.println("Ejecutando test solo en Windows");
        }

        @Test
        @DisplayName("Probando test solo en Linux y Mac")
        @EnabledOnOs({OS.LINUX, OS.MAC}) // Habilita la prueba solo en Linux y Mac
        void testSoloLinuxMac() {
            System.out.println("Ejecutando test solo en Linux y Mac");
        }

        @Test
        @DisplayName("Probando test en cualquier OS menos en Windows")
        @DisabledOnOs(OS.WINDOWS) // Deshabilita la prueba en Windows
        void testNoWindows() {
            System.out.println("Ejecutando test en cualquier OS menos en Windows");
        }
    }

    @Nested
    @DisplayName("Tests relacionados con la versión de Java")
    class JavaVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8) // Habilita la prueba solo en Java 8
        void soloJDK8() {
            System.out.println("Ejecutando en Java 8");
        }

        @Test
        @EnabledOnJre(JRE.JAVA_22) // Habilita la prueba solo en Java 22
        void soloJDK22() {
            System.out.println("Ejecutando en Java 22");
        }

        @Test
        @DisabledOnJre(JRE.JAVA_22) // Deshabilita la prueba en Java 22
        void testNoJDK22() {
            System.out.println("Ejecutando en cualquier versión de Java menos en Java 22");
        }
    }

    @Nested
    @DisplayName("Tests relacionados con las propiedades del sistema")
    class SystemPropertiesTest {
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ": " + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "22") // Habilita la prueba si la versión de Java es 22.0
        void testJavaVersion() {
            System.out.println("Ejecutando en Java version 22");
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*") // Deshabilita la prueba si la arquitectura es de 64 bits
        void testSolo64() {
            System.out.println("Ejecutando en arquitectura de 64 bits");
        }

        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*") // Habilita la prueba si la arquitectura es de 32 bits
        void TestNo64() {
        }
    }

    @Nested
    @DisplayName("Tests relacionados con las variables de entorno")
    class VariableAmbienteTest {
        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + ": " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-20.*") // Habilita la prueba si la variable de entorno JAVA_HOME contiene jdk-20
        void testJavaHome() {
            System.out.println("Ejecutando si la variable de entorno JAVA_HOME contiene jdk-20");
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8") // Habilita la prueba si la variable de entorno NUMBER_OF_PROCESSORS contiene 12
        void testProcesadores() {
            System.out.println("Ejecutando si la variable de entorno NUMBER_OF_PROCESSORS contiene 8");
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "DEV") // Habilita la prueba si la variable de entorno ENV es dev
        void testEnv() {
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "PROD") // Deshabilita la prueba si la variable de entorno ENVIRONMENT es prod
        void testEnvProdDisabled() {
        }
    }
}
