public enum TipoAutomovil {
    SEDAN("Sedán", "Auto mediano", 4),
    STATION_WAGON("Station Wagon", "Auto familiar", 4),
    HATCHBACK("Hatchback", "Auto pequeño", 4),
    PICKUP("Pickup", "Camioneta", 2),
    COUPE("Coupé", "Auto pequeño", 2),
    CONVERTIBLE("Convertible", "Auto deportivo", 2),
    FURGON("Furgón", "Auto utilitario", 4);

    private final String nombre;
    private final int numeroPuertas;
    private final String descripcion;

    TipoAutomovil(String nombre, String descripcion, int numeroPuertas ) {
        this.nombre = nombre;
        this.numeroPuertas = numeroPuertas;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
