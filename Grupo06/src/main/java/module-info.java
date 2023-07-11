module general {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphics;
    requires transitive java.desktop;
    requires javafx.swing;
    requires transitive org.apache.commons.io;
    
    opens general to javafx.fxml;
    exports general;
}
