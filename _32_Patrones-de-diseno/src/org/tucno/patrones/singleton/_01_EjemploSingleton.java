package org.tucno.patrones.singleton;

public class _01_EjemploSingleton {
    public static void main(String[] args) {
        ConexionBDSingleton conexion = null;

        for (int i = 0; i < 10; i++) {
            conexion = ConexionBDSingleton.getInstancia();
            System.out.println(conexion);
        }

         ConexionBDSingleton conexion2 = ConexionBDSingleton.getInstancia();
         ConexionBDSingleton conexion3 = ConexionBDSingleton.getInstancia();

         boolean sonIguales = ((conexion2 == conexion3) &&  (conexion == conexion2));
            System.out.println("¿Son iguales?: " + sonIguales);

    }
}
