import java.util.Scanner;

public class _04SentenciaSwitchCaseNombreMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número del mes: ");
        int mes = scanner.nextInt();
        
        String nombreMes = switch (mes) {
            case 1 -> nombreMes = "Enero";
            case 2 -> nombreMes = "Febrero";
            case 3 -> nombreMes = "Marzo";
            case 4 -> nombreMes = "Abril";
            case 5 -> nombreMes = "Mayo";
            case 6 -> nombreMes = "Junio";
            case 7 -> nombreMes = "Julio";
            case 8 -> nombreMes = "Agosto";
            case 9 -> nombreMes = "Septiembre";
            case 10 -> nombreMes = "Octubre";
            case 11 -> nombreMes = "Noviembre";
            case 12 -> nombreMes = "Diciembre";
            default -> nombreMes = "Mes invalido";
        };
        
        System.out.println("nombreMes = " + nombreMes);
    }
}
