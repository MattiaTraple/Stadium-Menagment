module simulation.stadiummanaging {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens simulation.main to javafx.fxml;
    exports simulation.main;
}