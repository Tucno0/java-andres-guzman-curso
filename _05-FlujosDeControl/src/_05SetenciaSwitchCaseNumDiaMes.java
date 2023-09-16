import java.util.Scanner;

public class _05SetenciaSwitchCaseNumDiaMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el mes (1-12): ");
        int mes = scanner.nextInt();
        
        System.out.print("Introduce el año: ");
        int anio = scanner.nextInt();
        
        int numeroDias = 0;
        
        // con switch
        numeroDias = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31; // case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            case 4, 6, 9, 11 -> 30; // case 4: case 6: case 9: case 11:
            case 2 -> {
                if ((anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0)) {
                    yield 29; // yield es como un return
                } else {
                    yield 28;
                }
            }
            default -> 0;
        };
        
        // con if else
        /*if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            numeroDias = 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            numeroDias = 30;
        } else if (mes == 2) {
            if ((anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0)) {
                numeroDias = 29;
            } else {
                numeroDias = 28;
            }
        } else {
            System.out.println("El mes introducido no es correcto");
        }*/
        
        System.out.println("numeroDias = " + numeroDias);
    }
}
