package com.manuelzacarias.hotel.Controllers;

import com.manuelzacarias.hotel.HotelMain;
import com.manuelzacarias.hotel.Models.Ejecutiva;
import com.manuelzacarias.hotel.Models.Habitacion;
import com.manuelzacarias.hotel.Models.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class Administrador {

    @FXML
    private Button salir;

    @FXML
    private TextArea texto;
    private Hotel hotel;
    private Stage stage;


    public void ponerStage (Stage stage){
        this.stage=stage;
    }
    public void ponerHotel (Hotel hotel){
        this.hotel=hotel;
    }

    @FXML
    void darDeAltahabitacion(MouseEvent event){
        agregarHabitacion();
        imprimiraHabitacionesDisponibles();
    }

    @FXML
    void habitacionOcupadas(MouseEvent event) {
        imprimirHabitacionOcupadas();
    }

    @FXML
    void habitacionesDisponibles(MouseEvent event) {
        imprimiraHabitacionesDisponibles();
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
    public void imprimiraHabitacionesDisponibles() {
        texto.setText(hotel.imprimirHabitacionesVacias());
    }
    void imprimirHabitacionOcupadas() {
        texto.setText(hotel.imprimirHabitacionesOcupadas());
    }

    public void agregarHabitacion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType normal = new ButtonType("Normal");
        ButtonType ejecutiva = new ButtonType("Ejecutiva");
        alert.getButtonTypes().setAll(normal,ejecutiva);
        alert.setTitle("Dar de alta habitacion");
        alert.setHeaderText("Tipo de habitacion a agregar");
        alert.showAndWait().ifPresent(respuesta ->{
            if (respuesta==normal){
                Habitacion nuevaHabitacion = new Habitacion();
                Random random = new Random();
                int randomNum = random.nextInt(1000);
                nuevaHabitacion.setID(randomNum);
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Dar de alta habitacion");
                dialog.setHeaderText("Precio de habitacion:");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(nuevaHabitacion::setPrecioDeHabitacion);
                nuevaHabitacion.setFechaEntrada("Disponible");
                nuevaHabitacion.setFechaSalida("Disponible");
                hotel.setHabitaciones(nuevaHabitacion);
            } else {
                Ejecutiva nuevaHabitacion = new Ejecutiva();
                Random random = new Random();
                int randomNum = random.nextInt(1000);
                nuevaHabitacion.setID(randomNum);
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Dar de alta habitacion");
                dialog.setHeaderText("Precio de habitacion:");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(nuevaHabitacion::setPrecioDeHabitacion);
                dialog.setTitle("Dar de alta habitacion");
                dialog.setHeaderText("Numero de televisiones:");
                Optional<String> tel = dialog.showAndWait();
                tel.ifPresent(nuevaHabitacion::setNumeroDeTelevisiones);
                dialog.setTitle("Dar de alta habitacion");
                dialog.setHeaderText("Modelo de camas:");
                Optional<String> modelo = dialog.showAndWait();
                modelo.ifPresent(nuevaHabitacion::setModeloDeCama);
                dialog.setTitle("Dar de alta habitacion");
                dialog.setHeaderText("Numero de jacuzzis:");
                Optional<String> jacuzzis = dialog.showAndWait();
                jacuzzis.ifPresent(nuevaHabitacion::setNumeroDeJacuzzis);
                nuevaHabitacion.setFechaEntrada("Disponible");
                nuevaHabitacion.setFechaSalida("Disponible");
                hotel.setHabitaciones(nuevaHabitacion);
            }
        });
    }
}