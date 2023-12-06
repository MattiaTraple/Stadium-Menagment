module simulation.stadiummanaging {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jakarta.persistence;


    opens simulation.main to javafx.fxml;
    exports simulation.main;
}