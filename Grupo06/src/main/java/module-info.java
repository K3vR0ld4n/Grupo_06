module general {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphics;

    opens general to javafx.fxml;
    exports general;
}
