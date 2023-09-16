import javax.swing.*;

public class SistemasNumericosJOptionPane06 {
    public static void main(String[] args) {
        
        String numeroStr = JOptionPane.showInputDialog(null, "Ingrese un número entero: ", "Decimal a otros sistemas numéricos", JOptionPane.INFORMATION_MESSAGE);
        
        int numeroDecimal;
        
        try {
            numeroDecimal = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            numeroDecimal = 0;
            System.out.println("Error debe ingresar un número entero");
            JOptionPane.showMessageDialog(null, "Error debe ingresar un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            main(args);
            System.exit(0);
        }
        
        //Convertir el número decimal a un número binario
        System.out.println("numeroDecimal = " + numeroDecimal);
        System.out.println("numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal));
        
        // Convertir un número binario a un número decimal
        int numeroBinario = 0b111110100; // Se antepone 0b al número binario
        System.out.println("numeroBinario = " + numeroBinario);
        
        // Convertir un número decimal a un número octal
        System.out.println("numero octal de " + numeroBinario + " = " + Integer.toOctalString(numeroDecimal));
        int numeroOctal = 0764; // Se antepone 0 al número octal
        System.out.println("numeroOctal = " + numeroOctal);
        
        // Convertir un número decimal a un número hexadecimal
        System.out.println("numero hexadecimal de " + numeroDecimal + " = " + Integer.toHexString(numeroDecimal));
        int numeroHexadecimal = 0x1f4; // Se antepone 0x al número hexadecimal
        System.out.println("numeroHexadecimal = " + numeroHexadecimal);
        
        String mensaje = "numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal);
        mensaje += "\nnumero octal de " + numeroDecimal + " = " + Integer.toOctalString(numeroDecimal);
        mensaje += "\nnumero hexadecimal de " + numeroDecimal + " = " + Integer.toHexString(numeroDecimal);
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
