package org.jhampier.java8.lambda;

import org.jhampier.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _03_Predicate {
    public static void main(String[] args) {
        // Predicate es una interfaz funcional que recibe un parámetro y devuelve un valor booleano
        // Tiene el método test que recibe un parámetro y devuelve un valor booleano
        // Predicate<tipo de dato del parámetro> nombre = parámetro -> {cuerpo de la función}

        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(11);
        System.out.println("r = " + r);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        boolean isRoleAdmin = test2.test("ROLE_ADMIN");
        System.out.println("isRoleAdmin = " + isRoleAdmin);

        // BiPredicate es una interfaz funcional que recibe dos parámetros y devuelve un valor booleano
        BiPredicate<String, String> test3 = (a, b) -> a.equals(b);
        boolean r2 = test3.test("Hola", "hola");
        System.out.println("r2 = " + r2);

        BiPredicate<Integer, Integer> test4 = (a, b) -> a > b;
        boolean r3 = test4.test(10, 11);
        System.out.println("r3 = " + r3);

        // Ejemplo de Predicate con una clase (Usuario)
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Pablo");

        BiPredicate<Usuario, Usuario> test5 = (u1, u2) -> u1.getNombre().equals(u2.getNombre());
        boolean r4 = test5.test(usuario, usuario2);
        System.out.println("r4 = " + r4);
    }
}
