public enum Color {
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    VERDE("Verde"),
    BLANCO("Blanco"),
    GRIS("Grís Oscuro"),
    NARANJO("Naranjo");

    private final String color;

    Color( String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
