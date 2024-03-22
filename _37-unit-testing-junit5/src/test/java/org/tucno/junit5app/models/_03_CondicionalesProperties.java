package org.tucno.junit5app.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class _03_CondicionalesProperties {
    // 377. Test condicionales @EnabledOnOs, @EnabledOnJre, @EnabledIfSystemProperty etc...
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
        System.out.println("Ejecutando en arquitectura de 32 bits");
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "jhampier") // Habilita la prueba si el nombre de usuario es jhampier
    void testUserName() {
        System.out.println("Ejecutando si el nombre de usuario es jhampier");
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev") // Habilita la prueba si la variable de entorno ENV es dev
    void testDev() {
        System.out.println("Ejecutando si la variable de entorno es dev");
    }
}
