package org.tucno.hibernateapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_detalles")
public class ClienteDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean prime;

    @Column(name = "puntos_acumulados")
    private Long puntosAcumulados;

    public ClienteDetalle() {
    }

    public ClienteDetalle(boolean prime, Long puntosAcumulados) {
        this.prime = prime;
        this.puntosAcumulados = puntosAcumulados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public Long getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(Long puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }


    @Override
    public String toString() {
        return "ClienteDetalle{" +
                "id=" + id +
                ", prime='" + prime + '\'' +
                ", puntosAcumulados=" + puntosAcumulados +
                '}';
    }
}
