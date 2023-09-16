import javax.swing.*;

public class _17TareaNombreMasLargo {
    public static void main(String[] args) {
        String nombre1, nombre2, nombre3, nombreLargo;
        
        nombre1 = JOptionPane.showInputDialog("Ingrese el primer nombre y apellido: ");
        nombre2 = JOptionPane.showInputDialog("Ingrese el segundo nombre y apellido: ");
        nombre3 = JOptionPane.showInputDialog("Ingrese el tercer nombre y apellido: ");
        
        nombreLargo = (nombre1.split(" ")[0].length() > nombre2.split(" ")[0].length())
                ? nombre1
                : nombre2;
        
        nombreLargo = (nombre3.split(" ")[0].length() > nombreLargo.split(" ")[0].length())
                ? nombre3
                : nombreLargo;
        
        JOptionPane.showMessageDialog(null, nombreLargo.concat(" tiene el nombre mas largo."));
    }
}
