module simulation.stadiummanaging {
    requires javafx.controls;
    requires javafx.fxml;


    opens simulation.stadiummanaging to javafx.fxml;
    exports simulation.stadiummanaging;
}