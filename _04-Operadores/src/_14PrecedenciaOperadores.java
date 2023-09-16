public class _14PrecedenciaOperadores {
    public static void main(String[] args) {
        int i = 14;
        int j = 8;
        int k = 20;
        
        double promedio = (i + j + k) / 3d; // 42 / 3 = 14.0
        System.out.println("promedio = " + promedio);
        
        promedio = i + j + k / 3d * 10; // 14 + 8 + 6.666666666666667 * 10 = 86.66666666666667
        System.out.println("promedio = " + promedio);
        
        promedio = i + j + k / (3d * 10); // 14 + 8 + 0.6666666666666666 = 22.666666666666668
        System.out.println("promedio = " + promedio);
        
        promedio = (i + j + k) / (3d * 10); // 42 / 30 = 1.4
        System.out.println("promedio = " + promedio);
        
        promedio = (i + j + k) / 3d * 10; // 42 / 3 * 10 = 140.0
        System.out.println("promedio = " + promedio);
        
        promedio = ++i + j-- + k / 3d * 10; // 15 + 8 + 66.6 = 89.6
        System.out.println("promedio = " + promedio);
    }
}
