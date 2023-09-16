import java.util.Scanner;

public class _16TareaEstanqueDeGasolina {
    public static void main(String[] args) {
        Double capacidad = 70d;
        Double medidaActual = 0d;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la medida actual del estanque: ");
        medidaActual = scanner.nextDouble();
        
        String resultado = (medidaActual.equals(capacidad))
            ? "Estanque lleno"
            : (medidaActual < 70 && medidaActual >= 60)
                ? "Estaque casi lleno"
                : (medidaActual < 60 && medidaActual >= 40)
                    ? "Estaque 3/4"
                    : (medidaActual < 40 && medidaActual >= 35)
                        ? "Medio Estanque"
                        : (medidaActual < 35 && medidaActual >= 20)
                            ? "Suficiente"
                            : (medidaActual < 20 && medidaActual >= 0)
                                ? "Insuficiente"
                                : "Dato no valido";
        
        System.out.println("resultado = " + resultado);
    }
}
