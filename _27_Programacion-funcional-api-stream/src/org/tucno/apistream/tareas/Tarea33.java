package org.tucno.apistream.tareas;

import java.util.stream.Stream;

public class Tarea33 {
    public static void main(String[] args) {
        String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};

        String[] len = Stream.of(lenguajes)
                .flatMap(l -> Stream.of(l))
                .distinct()
                .toArray(String[]::new); // forma larga: .toArray(s -> new String[s]);

        for (String l : len) {
            System.out.println(l);
        }
    }
}
