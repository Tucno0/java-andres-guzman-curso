package org.tucno.hibernateapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Entity es una anotación de JPA que indica que la clase es una entidad de la base de datos
@Entity
@Table(name = "clientes") // Indica el nombre de la tabla en la base de datos
public class Cliente {
    @Id // Indica que el campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue indica que el campo es autoincremental
    private Long id;

    // Column indica que el campo es una columna de la tabla, se puede omitir si el nombre del campo es igual al de la columna
    private String nombre;
    private String apellido;

    @Column(name = "forma_pago") // Indica el nombre de la columna en la base de datos
    private String formaPago;

    // Embedded es una anotación de JPA que indica que la clase es embebible, es decir, que se puede usar como parte de otra entidad
    // En este caso, la clase Auditoria se usará como parte de la entidad Cliente para registrar la fecha de creación y edición
    @Embedded
    private Auditoria auditoria = new Auditoria();

    // OneToMany indica que la relación es de uno a muchos, es decir, que un cliente puede tener muchas direcciones
    // fetch = FetchType.EAGER indica que las direcciones se cargarán automáticamente cuando se acceda al cliente
    // fetch = FetchType.LAZY indica que las direcciones se cargarán solo cuando se acceda a ellas
    // Por defecto fetch en una relación OneToMany es LAZY
    // cascade indica que las operaciones de guardado, actualización y eliminación se propagarán a las direcciones
    // orphanRemoval indica que las direcciones huérfanas (sin cliente) serán eliminadas de la base de datos
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // Indica el nombre de la columna en la tabla direcciones que será la clave foránea, solo crearía una columna en la tabla direcciones y ya no una tabla intermedia
    // @JoinColumn(name = "id_cliente")
    @JoinTable( // Indica que la relación se mapeará a través de una tabla intermedia
            name = "clientes_direcciones", // Indica el nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_cliente"), // Indica el nombre de la columna en la tabla intermedia que será la clave foránea
            inverseJoinColumns = @JoinColumn(name = "id_direccion"), // Indica el nombre de la columna en la tabla intermedia que será la clave foránea
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_direccion"}) // Indica que la combinación de id_cliente e id_direccion debe ser única
    )
    private List<Direccion> direcciones;

    // mappedBy indica el nombre del campo en la clase Factura que mapea la relación, en este caso, el campo cliente de la clase Factura
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    // JoinColumn aquí no va poque es bidireccional y ya está en la otra clase
    private  List<Factura> facturas;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "cliente"
    )
    private ClienteDetalle detalle;

    // Constructor vacío: necesario para que JPA pueda instanciar la clase
    public Cliente() {
        this.direcciones = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public  Cliente addFactura(Factura factura){
        this.facturas.add(factura);
        factura.setCliente(this);
        return this;
    }

    public void removeFactura(Factura factura){
        this.facturas.remove(factura);
        factura.setCliente(null);
    }

    public ClienteDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(ClienteDetalle detalle) {
        this.detalle = detalle;
    }

    public void addDetalle(ClienteDetalle detalle) {
        this.detalle = detalle;
        detalle.setCliente(this);
    }

    public void removeDetalle() {
        if (this.detalle != null) {
            this.detalle.setCliente(null);
            this.detalle = null;
        }
    }

    @Override
    public String toString() {
        LocalDateTime creadoEn = this.auditoria != null ? this.auditoria.getCreadoEn() : null;
        LocalDateTime editadoEn = this.auditoria != null ? this.auditoria.getEditadoEn() : null;

        return "{" + "\n" +
                    "   id: " + id + ",\n" +
                    "   nombre: " + nombre + ",\n" +
                    "   apellido: " + apellido + ",\n" +
                    "   formaPago: " + formaPago + ",\n" +
                    "   creadoEn: " + creadoEn + ",\n" +
                    "   editadoEn: " + editadoEn + "\n" +
                    "   direcciones: " + direcciones + "\n" +
                    "   facturas: " + facturas + "\n" +
                    "   detalle: " + detalle + "\n" +
                "}," + "\n";
    }
}
