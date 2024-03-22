package org.tucno.junit5app.models;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class _11_Timeout {
    @Nested
    @Tag("timeout")
    class PruebasTimeout {
        @Test
        @Timeout(1) // El test fallará si tarda más de 5 segundos
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 1000, unit = TimeUnit.MICROSECONDS) // El test fallará si tarda más de 5 segundos
        void pruebaTimeout2() throws InterruptedException {
            // No se especifica el tiempo, por lo que se usará el valor por defecto de 5 segundos
            TimeUnit.MICROSECONDS.sleep(1000);
        }

        @Test
        @Disabled
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.SECONDS.sleep(4000);
            });
        }
    }
}
