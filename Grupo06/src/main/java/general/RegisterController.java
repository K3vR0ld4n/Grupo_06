package general;

import TDAs.ArrayList;
import modules.Alertas;
import modules.Serialization;
import modules.Register;
import java.io.IOException;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modules.Login;

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
        Register newRegister = new Register(name, password, mail);
        Login user = new Login(name, password);
        System.out.println(Register.RegisterArray);
        Serialization.serialize(Register.RegisterArray, "register");
        
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