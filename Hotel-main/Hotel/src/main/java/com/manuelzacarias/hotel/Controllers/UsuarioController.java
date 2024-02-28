package com.manuelzacarias.hotel.Controllers;

import com.manuelzacarias.hotel.HotelMain;
import com.manuelzacarias.hotel.Models.Habitacion;
import com.manuelzacarias.hotel.Models.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class UsuarioController {

    @FXML
    private TextArea listaHabitacionesDisponibles;

    @FXML
    void ocuparHabitacion(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eliga ");
        dialog.setHeaderText("Ingrese ID de la habitacion a ocupar");
        Optional<String> productoEli = dialog.showAndWait();
        productoEli.ifPresent(producto -> {
            for (Habitacion habitacion1: hotel.getHabitaciones()) {
                if (habitacion1.getID()==Integer.parseInt(producto)) {
                    dialog.setTitle("Ocupar habitacion");
                    dialog.setHeaderText("Fecha de entrada:");
                    Optional<String> fa = dialog.showAndWait();
                    fa.ifPresent(habitacion1::setFechaEntrada);
                    dialog.setHeaderText("Fecha de salida:");
                    Optional<String> fs = dialog.showAndWait();
                    fs.ifPresent(habitacion1::setFechaSalida);
                    habitacion1.setOcupada();
                }
            }
        });
        imprimirHabitaciones();
    }

    @FXML
    void salir(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HotelMain.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hotel");
        stage.setScene(scene);
        stage.show();
        Menu menu = fxmlLoader.getController();
        menu.ponerStage(stage);
        menu.ponerHotel(hotel);
    }
    private Stage stage;
    private Hotel hotel;

    public void ponerStage (Stage stage){
        this.stage=stage;
    }
    public void ponerHotel(Hotel hotel){
        this.hotel = hotel;
    }
    public void imprimirHabitaciones(){
    listaHabitacionesDisponibles.setText(hotel.imprimirHabitacionesVacias());
    }
}