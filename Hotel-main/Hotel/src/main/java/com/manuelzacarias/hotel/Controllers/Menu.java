package com.manuelzacarias.hotel.Controllers;

import com.manuelzacarias.hotel.HotelMain;
import com.manuelzacarias.hotel.Models.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Menu {

    private Hotel hotel = new Hotel();
    private Stage stage;

    private String password = "1234";


    public void ponerHotel(Hotel hotel){
        this.hotel=hotel;
    }

    public void ponerStage(Stage stage){
        this.stage=stage;
    }

    @FXML
    void botonadministrador(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Hotel");
        dialog.setContentText("Ingrese contraseña de administrador");
        Optional<String> pas = dialog.showAndWait();
        pas.ifPresent(result-> {
            if (result.equals(password)) {
                FXMLLoader fxmlLoader = new FXMLLoader(HotelMain.class.getResource("Administrador.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Hotel");
                stage.setScene(scene);
                stage.show();
                Administrador administrador = fxmlLoader.getController();
                administrador.ponerHotel(hotel);
                administrador.ponerStage(stage);
            }
        });
    }

    @FXML
    void botoningresar(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HotelMain.class.getResource("Usuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hotel");
        stage.setScene(scene);
        stage.show();
        UsuarioController usuarioController = fxmlLoader.getController();
        usuarioController.ponerStage(stage);
        usuarioController.ponerHotel(hotel);
        usuarioController.imprimirHabitaciones();
    }

    @FXML
    void botonsalir(MouseEvent event) {
    stage.close();
    }

}
