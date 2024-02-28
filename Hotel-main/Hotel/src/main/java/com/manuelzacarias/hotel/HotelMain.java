package com.manuelzacarias.hotel;

import com.manuelzacarias.hotel.Controllers.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HotelMain.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hotel");
        stage.setScene(scene);
        stage.show();
        Menu menu = fxmlLoader.getController();
        menu.ponerStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}