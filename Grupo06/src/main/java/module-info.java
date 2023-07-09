module general {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphics;
    requires transitive java.desktop;
    requires javafx.swing;
    opens general to javafx.fxml;
    exports general;
}
