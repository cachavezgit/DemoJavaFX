module com.wilsondevelopment.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.wilsondevelopment.demojavafx to javafx.fxml;
    exports com.wilsondevelopment.demojavafx;
    exports com.wilsondevelopment.demojavafx.controllers;
    opens com.wilsondevelopment.demojavafx.controllers to javafx.fxml;
}