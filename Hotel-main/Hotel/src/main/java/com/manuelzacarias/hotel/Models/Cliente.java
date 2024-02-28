package com.manuelzacarias.hotel.Models;

public class Cliente {
    String nombre;
    String numTel;
    String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Nombre ='" + nombre + '\'' +
                ", Telefono ='" + numTel + '\'' +
                ", Correo ='" + correo + '\'';
    }
}
