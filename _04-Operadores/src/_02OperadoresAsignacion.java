public class _02OperadoresAsignacion {
    public static void main(String[] args) {
        // Operadores de asignación
        
        // Asignación simple
        int i = 5;
        int j = i + 4;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        
        // Asignación compuesta u operadores combinados
        i += 2; // i = i + 2
        System.out.println("\ni = " + i);
        
        i += 5; // i = i + 5
        System.out.println("i = " + i);
        
        j -= 4; // j = j - 4
        System.out.println("\nj = " + j);
        
        j *= 3; // j = j * 3
        System.out.println("j = " + j);
        
        String sqlString = "select * from clientes as c";
        sqlString += " where c.nombre = 'Andrés Guzmán'";
        sqlString += " and c.activo = 1";
        System.out.println("\nsqlString = " + sqlString);
    }
}
