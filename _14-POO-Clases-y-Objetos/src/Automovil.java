public class Automovil {
    // Atributos
    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;
    private Rueda[] ruedas;

    private TipoAutomovil tipo;

    // Atributos estáticos
    private static Color colorPlaca = Color.NARANJO;
    private static int estanqueEstatico = 30;
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

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color); // Llamada al constructor con tres argumentos (this)
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque) {
        this(fabricante, modelo, color, motor); // Llamada al constructor con cuatro argumentos (this)
        this.estanque = estanque;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, estanque); // Llamada al constructor con cinco argumentos (this)
        this.conductor = conductor;
        this.ruedas = ruedas;
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
    public static Color getColorPlaca() {
        return colorPlaca;
    }
    public static void setColorPlaca(Color colorPlaca) {
        Automovil.colorPlaca = colorPlaca;
    }
    public static int getCapacidadEstanqueEstatico() {
        return estanqueEstatico;
    }
    public static void setCapacidadEstanqueEstatico(int estanqueEstatico) {
        Automovil.estanqueEstatico = estanqueEstatico;
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

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Estanque getEstanque() {
        return estanque;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    // Métodos sin argumentos
    public String verDetalle() {
        return  "\nauto.id = " + this.id +
                "\nauto.fabricante = " + this.fabricante +
                "\nauto.modelo = " + this.modelo +
                "\nauto.tipo = " + this.tipo.getDescripcion() +
                "\nauto.color = " + this.color.getColor() +
                "\nauto.colorPlaca = " + Automovil.colorPlaca.getColor() + // Atributo estático
                "\nauto.cilindrada = " + this.motor.getCilindrada() +
                "\nauto.estanque = " + this.estanque.getCapacidad();
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
        return km / (this.estanque.getCapacidad() * porcentajeBencina);
    }

    public float calcularConsumo( int km, int porcentajeBencina ) {
        return km / (this.estanque.getCapacidad() * (porcentajeBencina / 100f));
    }

    public static float calcularConsumoEstatico( int km, float porcentajeBencina ) {
        return km / (Automovil.estanqueEstatico * porcentajeBencina);
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
                "\nmotor=" + motor +
                "\nestanque=" + estanque;
    }
}
