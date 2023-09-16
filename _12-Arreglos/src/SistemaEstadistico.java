import java.util.Scanner;

public class SistemaEstadistico {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[7];
        double sumaPositivos = 0, sumaNegativos = 0;
        int contPositivos = 0, contNegativos = 0, contCeros = 0;
        double promedioPositivos, promedioNegativos;
        
        // Llenar el arreglo, sumar y contar
        System.out.println("Ingrese 7 numeros:");
        for (int i = 0; i < numeros.length; i++ ) {
            System.out.print("Ingrese numero " + (i+1) + ": ");
            numeros[i] =  entrada.nextInt();
            
            if (numeros[i] < 0) {
                sumaNegativos += numeros[i];
                contNegativos++;
            } else if (numeros[i] == 0) {
                contCeros++;
            } else {
                sumaPositivos += numeros[i];
                contPositivos++;
            }
        }
        
        // Mostrar resultados
        if (contNegativos == 0) {
            System.out.println("No hay numeros negativos");
        } else {
            promedioNegativos = sumaNegativos / contNegativos;
            System.out.println("\nPromedio de numeros negativos: " + promedioNegativos);
        }
        
        if (contPositivos == 0) {
            System.out.println("No hay numeros positivos");
        } else {
            promedioPositivos = sumaPositivos / contPositivos;
            System.out.println("Promedio de numeros positivos: " + promedioPositivos);
        }
        
        System.out.println("Cantidad de ceros: " + contCeros);
    }
}
