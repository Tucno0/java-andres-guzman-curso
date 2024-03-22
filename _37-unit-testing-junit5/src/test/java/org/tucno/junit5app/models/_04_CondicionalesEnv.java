package org.tucno.junit5app.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.Map;

public class _04_CondicionalesEnv {
    //=============== 378. Ejecuciones de test condicionales con @EnabledIfEnvironmentVariable ===============
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
