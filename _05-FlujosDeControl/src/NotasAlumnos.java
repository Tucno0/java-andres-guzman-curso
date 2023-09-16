import java.util.Scanner;

public class NotasAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] notas = new double[10];
        
        double sumaNotas = 0, sumaNotasMayores5 = 0, sumaNotasMenores4 = 0;
        double promedioTotal = 0, promedioNotasMayores5 = 0, promedioNotasMenores4 = 0;
        int contadorNotasMayores5 = 0, contadorNotasMenores4 = 0, contadornotas1 = 0;
        
        System.out.println("Ingresar notas escala 1-7 ...");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            
            
            if (notas[i] == 0) {
                System.out.println("Error... Finalizando el programa");
                System.exit(1);
            }
            
            if (notas[i] < 0 || notas[i] > 7) {
                System.out.println("Las notas deben estar entre [0-7]");
                System.exit(1);
            }
            
            if (notas[i] == 1) {
                contadornotas1++;
            } else if (notas[i] < 4) {
                contadorNotasMenores4++;
                sumaNotasMenores4 += notas[i];
            } else if (notas[i] > 5) {
                contadorNotasMayores5++;
                sumaNotasMayores5 += notas[i];
            }
            
            sumaNotas += notas[i];
        }
        
        System.out.println("Cantidad de notas 1 = " + contadornotas1);
        
        if (contadorNotasMenores4 != 0) {
            promedioNotasMenores4 = sumaNotasMenores4 / contadorNotasMenores4;
            System.out.println("Promedio de notas inferiores a 4 = " + promedioNotasMenores4);
        } else {
            System.out.println("No se encontraron notas inferiores a 4");
        }
        
        if (contadorNotasMayores5 != 0) {
            promedioNotasMayores5 = sumaNotasMayores5 / contadorNotasMayores5;
            System.out.println("Promedio de las notas mayores a 5 = " + promedioNotasMayores5);
        } else {
            System.out.println("No se encontraron notas superiores a 5");
        }
        
        promedioTotal = sumaNotas / notas.length;
        System.out.println("Promedio total = " + promedioTotal);
    }
}
