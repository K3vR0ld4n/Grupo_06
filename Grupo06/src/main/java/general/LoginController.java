package general;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField Txtname;

    @FXML
    private TextField TxtPasword;

    @FXML
    private Button BtLogin;

    @FXML
    private Label lblCrearCuenta;
    
    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("Register");
    }
    
    @FXML
    private void closeWindow() throws IOException{
        System.exit(0);
    }

}