package general;

import modules.*;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.Alertas;

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
    private void closeWindow() throws IOException {
        System.exit(0);
    }

    private static final Profile guest = new Profile("Guest", "Guest@guest.com");

    @FXML
    private void logIn() {
        try {
            String nameInput = this.Txtname.getText();
            String passwordInput = this.TxtPasword.getText();
            Alertas alert = new Alertas();
            if (nameInput.equals("") || passwordInput.equals("")) {
                alert.AlertWarning("Fill in all the fields");
            } else {
                boolean found = false;
                for (Profile p : Profile.arrayProfile) {
                    if (nameInput.equals(p.getName()) && passwordInput.equals(p.getPassword())) {
                        found = true;
                        EmojiSectionController.profile = p;
                        App.setRoot("EmojiSection");
                        break;
                    }
                }
                if (!found) {
                    alert.AlertWarning("User or password incorrect");
                }
            }

        } catch (Exception e) {
            System.out.println("INTENTE DE NUEVO");
        }

    }

    @FXML
    private void GuessMethod() throws IOException {
        EmojiSectionController.profile = guest;
        App.setRoot("EmojiSection");
    }

}
