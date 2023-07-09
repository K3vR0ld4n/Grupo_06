package general;

import TDAs.ArrayList;
import utils.Alertas;
import utils.Serialization;
import modules.Profile;
import java.io.IOException;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class RegisterController implements Initializable {

    @FXML
    private TextField TxtMail;

    @FXML
    private TextField TxtName;

    @FXML
    private TextField TxtPassword;

    @FXML
    private Button BtResgiter;

    @FXML
    private Label lblCrearCuenta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Este metodo sirve para cambiar de pestaña.
     *
     * @param
     */
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void closeWindow() throws IOException {
        System.exit(0);
    }

    @FXML
    private void RegisterButton() throws IOException {
        String name = TxtName.getText();
        String password = TxtPassword.getText();
        String mail = TxtMail.getText();
        Alertas alert = new Alertas();
        if (name.equals("") || password.equals("") || mail.equals("")) {
            alert.AlertError("Rellenos todos los campos");
        }
        Profile newRegister = new Profile(name, password, mail);
        
       
//        Serialization.serialize(Profile.arrayProfile, "profile");
        
        App.setRoot("Login");
    }

    @FXML
    private void eventKey(KeyEvent event) {
        Object evt = event.getSource();
        if (evt.equals(TxtName)) {
            if (!Character.isLetter(event.getCharacter().charAt(0))) {
                event.consume();
            }
        } else if (evt.equals(TxtPassword)) {
            if (TxtPassword.getText().length() > 10) {
                event.consume();
            }

        }
    }
}
