public class _02_ArgumentosLineaDeComandoCalculadora {
    public static void main(String[] args) {
        
        if (args.length != 3) {
            System.err.println("Debe ingresar 3 argumentos o parámetros!");
            System.err.println("Por favor, ingrese una operación (suma, resta, multiplicación, division) y dos números!");
            System.exit(-1);
        }
        
        String operacion = args[0];
        int a = 0;
        int b = 0;
        double resultado = 0;
        
        try {
            a = Integer.parseInt(args[1]);
            b = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Los argumentos 2 y 3 deben ser números enteros!");
            System.exit(-1);
        }
        
        switch (operacion) {
            case "suma":
                resultado = a + b;
                break;
            case "resta":
                resultado = a - b;
                break;
            case "multiplicacion":
                resultado = a * b;
                break;
            case "division":
                if (b == 0) {
                    System.err.println("No se puede dividir por cero!");
                    System.exit(-1);
                }
                resultado = (double) a / b;
                break;
            default:
                System.err.println("Operación no válida!");
                System.exit(-1);
        }
        
        System.out.println("El resultado de la operación " + operacion + " es: " + resultado);
    }
}
