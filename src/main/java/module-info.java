module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.Shatailo to javafx.fxml;
    exports com.example.Shatailo;
}