# Interfaces en Java

## Concepto
- Una interfaz es como una clase abstracta pero no permite que ninguno de sus métodos tenga implementación.
- Una interfaz es un tipo de referencia similar a una clase que puede contener solo constantes y declaraciones de métodos.
- Capturar similitudes entre clases no relacionadas sin forzar un relacion entre ellas.
- Es decir definen comportamientos que pueden ser implementados por cualquier clase.
- Es un tipo de dato de referencia, puede uilizarse como tipo de dato del objeto ( argumento de metodos y una declaracion de variables).

## Declaración
- Se utiliza la palabra reservada interface.
- Se pueden declarar constantes y métodos abstractos.
- No se pueden declarar variables de instancia.
- Todos los métodos de una interfaz son implícitamente publicos y abstractos.
- Todos los atributos de una interfaz son implícitamente publicos, estaticos y finales.
- Una interfaz no puede ser instanciada directamente.
- Una interfaz se implementa, una clase se extiende.
- Una clase puede implementar multiples interfaces.
- Una interfaz puede extender de multiples interfaces.
- Una interfaz no puede implementar una clase.

## Ejemplo
```java
public interface IPersona {
    int MAX = 10; // public static final int MAX = 10;
    void caminar(); // public abstract void caminar();
    String saludar(String nombre);
}
```