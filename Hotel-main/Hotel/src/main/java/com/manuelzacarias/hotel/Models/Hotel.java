package com.manuelzacarias.hotel.Models;

import java.util.ArrayList;

public class Hotel {
   ArrayList<Habitacion> habitaciones = new ArrayList<>();

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion habitaciones) {
        this.habitaciones.add(habitaciones);
    }

    public String imprimirHabitacionesVacias(){
        String habitacion = "";
        for (Habitacion habitacion1 : getHabitaciones()){
            if (!habitacion1.isOcupada()){
                habitacion = habitacion + habitacion1.toString() + "}" +"\n" ;
            }
        }
        return habitacion;
    }
    public String imprimirHabitacionesOcupadas(){
        String habitacion = "";
        for (Habitacion habitacion1 : getHabitaciones()){
            if (habitacion1.isOcupada()){
                habitacion = habitacion + habitacion1.toString() + ", Fecha entrada: " + habitacion1.fechaEntrada + "\n" + ", Fecha de salida: " +habitacion1.getFechaSalida()+"}"+"\n";}
        }
        return habitacion;
    }

}
