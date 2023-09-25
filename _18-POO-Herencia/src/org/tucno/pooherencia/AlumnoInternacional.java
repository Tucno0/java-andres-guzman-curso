package org.tucno.pooherencia;

/**
 * final en una clase: no se puede heredar de ella (no se puede crear clases hijas)
 */
public final class AlumnoInternacional extends Alumno{
    private String pais;
    private double notaIdiomas;

    // Constructor
    public AlumnoInternacional() {
        System.out.println("AlumnoInternacional: Inicializando constructor");
    }
    public AlumnoInternacional(String nombre, String apellido) {
        super(nombre, apellido);
    }
    public AlumnoInternacional(String nombre, String apellido, String pais) {
        super(nombre, apellido);
        this.pais = pais;
    }

    // Getters y Setters
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public double getNotaIdiomas() {
        return notaIdiomas;
    }
    public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }

    // Sobreescritura de métodos
    @Override
    public String saludar() {
        return super.saludar() + ",y soy de " + this.pais;
    }

    @Override
    public double calcularPromedio() {
        System.out.println("Calcular promedio " + AlumnoInternacional.class.getCanonicalName());
        return (( super.calcularPromedio() * 3 ) + this.notaIdiomas ) / 4;
    }

    @Override
    public String toString() {
        return  super.toString() + '\'' +
                "\npais = '" + pais +
                "\nnotaIdiomas = " + notaIdiomas;
    }
}
