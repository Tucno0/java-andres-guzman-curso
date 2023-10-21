package org.tucno.colecciones.tarea27;

import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaLlegada;
    private int numeroPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechaLlegada, int numeroPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.numeroPasajeros = numeroPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo: " + nombre + ", Origen: " + origen + ", Destino: " + destino + ", Fecha de llegada: " + fechaLlegada + ", Número de pasajeros: " + numeroPasajeros;
    }
}
