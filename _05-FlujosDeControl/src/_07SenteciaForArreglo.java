import javax.swing.*;

public class _07SenteciaForArreglo {
    public static void main(String[] args) {
        String[] nombres = {"Andres", "Pepe", "Maria", "Paco", "Lalo", "Bea", "Pato", "Pepa"};
        int count = nombres.length;
        
        for (int i = 0; i < count; i++) {
            if (nombres[i].equalsIgnoreCase("andres") || nombres[i].equalsIgnoreCase("pepa")) {
                continue;
            }
            System.out.println(i + ".- " + nombres[i]);
        }
        
        String buscar = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
        System.out.println("\nbuscar = " + buscar);
        
        boolean encontrado = false;
        
        for (int i = 0; i < count; i++) {
            if (nombres[i].equalsIgnoreCase(buscar)) {
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "El nombre " + buscar + " fue encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "El nombre " + buscar + " no existe en el sistema!");
        }
    }
}
