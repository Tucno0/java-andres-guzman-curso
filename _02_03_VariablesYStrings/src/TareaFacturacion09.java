import java.util.Scanner;

public class TareaFacturacion09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre de la factura: ");
        String nombreFactura = scanner.nextLine();
        
        System.out.print("Precio del producto 1: ");
        double precioProd1 = scanner.nextDouble();
        
        System.out.print("Precio del producto 2: ");
        double precioProd2 = scanner.nextDouble();
        
        double totalBruto = precioProd1 + precioProd2;
        double impuesto = totalBruto * 0.19;
        double totalNeto = totalBruto + impuesto;
        
        System.out.println( "\nNombre de la factura: " + nombreFactura +
                            "\nMonto total bruto: " + totalBruto +
                            "\nImpuesto: " + impuesto +
                            "\nTotal neto: " + totalNeto);
    }
}
