class Persona {
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class _03_PasarPorReferencia2 {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setNombre("Jhampier");
        
        System.out.println("Iniciamos el método main");
        
        System.out.println("persona.getNombre() = " + persona.getNombre());
        
        System.out.println("Antes de llamar al método test");
        test(persona);
        System.out.println("Después de llamar al método test");
        
        System.out.println("\npersona.getNombre() = " + persona.getNombre());
        
        System.out.println("Finalizamos el método main con los datos del arreglo modificados!");
    }
    
    public static void test(Persona persona) {
        System.out.println("\nIniciamos el método test");
        
        persona.setNombre("Jhampier Jhonatan");
        
        System.out.println("Finalizamos el método test");
    }
}
