package org.tucno.pooexcepciones.ejemploexcepciones;

public class Calculadora {
    // Esta excepción es una excepción checked, es necesario capturarla o lanzarla
    // Como estamos lanzaando con throw, nos obliga a propagar la excepción en el método que llama a este método
    // Si la excepcion fuera de tipo RuntimeException, no sería necesario capturarla o lanzarla
    // Un metodo puede lanzaar varias excepciones, separadas por coma. Ejm: throws DivisionPorZeroException, NumberFormatException
    public double dividir(int numerador, int divisor) throws DivisionPorZeroException {
        if (divisor == 0) {
            throw new DivisionPorZeroException("No se puede dividir por cero");
        }
        return numerador / (double) divisor;
    }

    public double dividir(String numerador, String divisor) throws DivisionPorZeroException, FormatoNumeroException {
        try {
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        } catch (NumberFormatException nfe) {
            throw new FormatoNumeroException("Por favor ingrese números válidos");
        }
    }
}
