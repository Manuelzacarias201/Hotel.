package com.manuelzacarias.hotel.Models;

public class Habitacion {
    protected Integer ID;
    protected boolean ocupada = false;
    protected String fechaEntrada;
    protected String fechaSalida;

    private String precioDeHabitacion;

    public boolean isOcupada() {
        return ocupada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrecioDeHabitacion(String precioDeHabitacion) {
        this.precioDeHabitacion = precioDeHabitacion;
    }

    public int getID() {
        return ID;
    }

    public void setOcupada() {
        ocupada = true;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Tipo de habitacion: Normal{" +
                "ID=" + ID + ", Precio De Habitacion='" + precioDeHabitacion + '\'';
    }
}
