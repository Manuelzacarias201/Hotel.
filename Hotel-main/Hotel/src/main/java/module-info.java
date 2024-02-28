module com.manuelzacarias.hotel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.manuelzacarias.hotel to javafx.fxml;
    exports com.manuelzacarias.hotel;
    exports com.manuelzacarias.hotel.Controllers;
    opens com.manuelzacarias.hotel.Controllers to javafx.fxml;
    exports com.manuelzacarias.hotel.Models;
    opens com.manuelzacarias.hotel.Models to javafx.fxml;
}