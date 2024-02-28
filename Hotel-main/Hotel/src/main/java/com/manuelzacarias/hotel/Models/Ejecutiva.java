package com.manuelzacarias.hotel.Models;

public class Ejecutiva extends Habitacion{
    String numeroDeTelevisiones;
    String ModeloDeCama;

    String numeroDeJacuzzis;

    public void setNumeroDeTelevisiones(String numeroDeTelevisiones) {
        this.numeroDeTelevisiones = numeroDeTelevisiones;
    }

    public void setModeloDeCama(String modeloDeCama) {
        ModeloDeCama = modeloDeCama;
    }

    public void setNumeroDeJacuzzis(String numeroDeJacuzzis) {
        this.numeroDeJacuzzis = numeroDeJacuzzis;
    }

    @Override
    public String toString() {
        return "Tipo de habitacion: Ejecutiva {" + "ID="  + ID + ", Numero de Televisiones=" + numeroDeTelevisiones + '\'' +
                ", Modelo de Cama='" + ModeloDeCama + '\'' +
                ", Numero de jacuzzis='" + numeroDeJacuzzis + '\'';
    }
}
