package com.manuelzacarias.hotel.Models;

public class Usuario {
    String nombre;
    String correo;
    String telefono;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre='" + nombre + '\'' +
                ", Correo='" + correo + '\'' +
                ", Telefono='" + telefono + '\'' +
                '}';
    }
}
