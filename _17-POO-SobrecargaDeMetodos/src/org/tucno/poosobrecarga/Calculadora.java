package org.tucno.poosobrecarga;

public class Calculadora {

    private Calculadora() { // Constructor privado para evitar instanciación
    }

    // Sobrecarga de métodos
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static float sumar(float x, float y) {
        return x + y;
    }

    public static float sumar(int i, float j) {
        return i + j;
    }

    public static float sumar(float i, int j) {
        return i + j;
    }

    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double sumar(double a, double b, double c) {
        return a + b + c;
    }

    public static double sumar(String a, String b) {
        int resultado;

        try {
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
        } catch (NumberFormatException e) {
            resultado = 0;
        }

        return resultado;
    }

    // Var Arguments
    public static int sumar(int... argumentos) { // int[] argumentos
        int suma = 0;
        for (int i = 0; i < argumentos.length; i++) {
            suma += argumentos[i];
        }
        return suma;
    }

    public static float sumar(float a, int... argumentos) { // int[] argumentos
        float suma = a;
        for (int i = 0; i < argumentos.length; i++) {
            suma += argumentos[i];
        }
        return suma;
    }

    public static double sumar(double... varargs) { // double[] varargs
        double suma = 0;
        for (int i = 0; i < varargs.length; i++) {
            suma += varargs[i];
        }
        return suma;
    }
}
