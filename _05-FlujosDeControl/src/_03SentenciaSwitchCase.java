public class _03SentenciaSwitchCase {
    public static void main(String[] args) {
        int dia = 5;
        
        // Ejemplo con switch: Esta es una forma mas compacta de escribir un switch, cada case es una expresión que devuelve un valor
        String nombreDia = switch (dia) { // Se puede usar byte, short, int, char, String y enum
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Dia invalido";
        };
        
        System.out.println("nombreDia = " + nombreDia);
    }
}
