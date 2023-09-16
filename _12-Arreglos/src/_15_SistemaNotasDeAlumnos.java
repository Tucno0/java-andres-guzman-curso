import java.util.Scanner;

public class _15_SistemaNotasDeAlumnos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        double[] claseMatematicas, claseHistoria, claseLenguaje;
        double sumaNotasMatematicas = 0, sumaNotasHistoria = 0, sumaNotasLenguaje = 0;
        
        claseMatematicas = new double[7];
        claseHistoria = new double[7];
        claseLenguaje = new double[7];
        
        // Llenar arreglos
        System.out.println("Ingrese las notas de los alumnos de Matemáticas: ");
        for (int i = 0; i < claseMatematicas.length; i++) {
            System.out.print("Ingrese la nota del alumno " + (i+1) + ": ");
            claseMatematicas[i] = entrada.nextDouble();
        }
        
        System.out.println("\nIngrese las notas de los alumnos de Historia: ");
        for (int i = 0; i < claseHistoria.length; i++) {
            System.out.print("Ingrese la nota del alumno " + (i+1) + ": ");
            claseHistoria[i] = entrada.nextDouble();
        }
        
        System.out.println("\nIngrese las notas de los alumnos de Lenguaje: ");
        for (int i = 0; i < claseLenguaje.length; i++) {
            System.out.print("Ingrese la nota del alumno " + (i+1) + ": ");
            claseLenguaje[i] = entrada.nextDouble();
        }
        
        // sumar notas
        for (int i = 0; i < claseMatematicas.length; i++) {
            sumaNotasMatematicas += claseMatematicas[i];
            sumaNotasHistoria += claseHistoria[i];
            sumaNotasLenguaje += claseLenguaje[i];
        }
        
        // Calcular promedios
        double promedioMatematicas = sumaNotasMatematicas / claseMatematicas.length;
        double promedioHistoria = sumaNotasHistoria / claseHistoria.length;
        double promedioLenguaje = sumaNotasLenguaje / claseLenguaje.length;
        
        System.out.println("\nPromedio de notas de Matemáticas: " + promedioMatematicas);
        System.out.println("Promedio de notas de Historia: " + promedioHistoria);
        System.out.println("Promedio de notas de Lenguaje: " + promedioLenguaje);
        
        // Calcular promedio general
        double promedioGeneral = (promedioMatematicas + promedioHistoria + promedioLenguaje) / 3;
        System.out.println("\nPromedio general: " + promedioGeneral);
        
        // Calcular promedio de notas de los alumnos que aprobaron
        System.out.println("\nIngrese el identificador del alumno (de 0 - 6): ");
        int id = entrada.nextInt();
        
        double promedioAlumno = (claseMatematicas[id] + claseHistoria[id] + claseLenguaje[id]) / 3;
        System.out.println("Promedio de notas del alumno " + id + ": " + promedioAlumno);
    }
}
