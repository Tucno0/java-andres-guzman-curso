public class Automovil {
    // Atributos
    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private double cilindrada;
    private int capacidadEstanque = 40;

    private TipoAutomovil tipo;

    // Atributos estáticos
    private static Color colorPlaca = Color.NARANJO;
    private static int capacidadEstanqueEstatico = 30;
    private static int ultimoId;

    // Atributos constantes (final)
    public static final Integer VELOCIDAD_MAX_CARRETERA = 120;
    public static final int VELOCIDAD_MAX_CIUDAD = 50;

    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_VERDE = "Verde";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris oscuro";


    // Constructores
    public Automovil() {
        this.id = ++ultimoId;
    }

    public Automovil(String fabricante, String modelo) {
        this(); // Llamada al constructor sin argumentos (this)
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        this(fabricante, modelo); // Llamada al constructor con dos argumentos (this
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada) {
        this(fabricante, modelo, color); // Llamada al constructor con tres argumentos (this)
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada, int capacidadEstanque) {
        this(fabricante, modelo, color, cilindrada); // Llamada al constructor con cuatro argumentos (this)
        this.capacidadEstanque = capacidadEstanque;
    }

    // Métodos de acceso (getters y setters)
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public double getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
    public int getCapacidadEstanque() {
        return capacidadEstanque;
    }
    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }
    public static Color getColorPlaca() {
        return colorPlaca;
    }
    public static void setColorPlaca(Color colorPlaca) {
        Automovil.colorPlaca = colorPlaca;
    }
    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }
    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        Automovil.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TipoAutomovil getTipo() {
        return tipo;
    }
    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    // Métodos sin argumentos
    public String verDetalle() {
        return  "\nauto.id = " + this.id +
                "\nauto.fabricante = " + this.fabricante +
                "\nauto.modelo = " + this.modelo +
                "\nauto.tipo = " + this.tipo.getDescripcion() +
                "\nauto.color = " + this.color.getColor() +
                "\nauto.colorPlaca = " + Automovil.colorPlaca.getColor() + // Atributo estático
                "\nauto.cilindrada = " + this.cilindrada +
                "\nauto.capacidadEstanque = " + this.capacidadEstanque;
    }

    public  String acelerar( int rmp ) {
        return "El automovil " + this.modelo + " acelera a " + rmp + " rpm";
    }

    public String frenar() {
        return "El automovil " + this.modelo + " esta frenando";
    }

    // Métodos con argumentos
    public String acelerarFrenar( int rmp ) {
        String acelerar = this.acelerar(rmp);
        String frenar = this.frenar();

        return acelerar + "\n" + frenar;
    }

    // sobrecarga de métodos
    public float calcularConsumo( int km, float porcentajeBencina ) {
        return km / (this.capacidadEstanque * porcentajeBencina);
    }

    public float calcularConsumo( int km, int porcentajeBencina ) {
        return km / (this.capacidadEstanque * (porcentajeBencina / 100f));
    }

    public static float calcularConsumoEstatico( int km, float porcentajeBencina ) {
        return km / (Automovil.capacidadEstanqueEstatico * porcentajeBencina);
    }

    @Override // Override indica que el método se sobreescribe
    public boolean equals(Object obj) {
        // Si el objeto es el mismo (this). Ejemplo: nissan.equals(nissan)
        if (this == obj) return true;
        // Si el objeto es el mismo
        if ( !(obj instanceof Automovil)) return false;
        Automovil a = (Automovil) obj;
        return  this.fabricante != null
                && this.modelo != null
                && this.fabricante.equals(a.fabricante)
                && this.modelo.equals(a.modelo);
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "\nid=" + id +
                "\nfabricante='" + fabricante +
                "\nmodelo='" + modelo +
                "\ncolor='" + color +
                "\ncilindrada=" + cilindrada +
                "\ncapacidadEstanque=" + capacidadEstanque;
    }
}
