package org.tucno.hibernateapp.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Long total;

    // Embedded es una anotación de JPA que indica que la clase es embebible, es decir, que se puede usar como parte de otra entidad
    // En este caso, la clase Auditoria se usará como parte de la entidad Cliente para registrar la fecha de creación y edición
    @Embedded
    private Auditoria auditoria = new Auditoria();

    // ManyToOne indica que la relación es de muchos a uno, es decir, que muchas facturas pueden pertenecer a un solo cliente
    // Se creara automáticamente una columna en la tabla facturas con el nombre cliente_id que será la clave foránea
    // JoinColumn indica que la columna que se creará en la tabla facturas se llamará id_cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Factura() {
    }

    public Factura(String descripcion, Long total) {
        this.descripcion = descripcion;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura {" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(id, factura.id) && Objects.equals(descripcion, factura.descripcion) && Objects.equals(total, factura.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, total);
    }
}
