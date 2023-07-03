package general;

import TDAs.ArrayList;
import modules.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    
    private static String userName = "";
    private static String email = "";

    @FXML
    private void logIn() {
        try {
            String nameInput = this.Txtname.getText();
            String passwordInput = this.TxtPasword.getText();

            if (nameInput.equals("") || passwordInput.equals("")) {
                Alertas alert = new Alertas();
                alert.AlertWarning("Complete todos los campos");
            }

            for (Profile p : Profile.arrayProfile) {
                if (nameInput.equals(p.getName()) && passwordInput.equals(p.getPassword())) {
                    userName = p.getName();
                    email = p.getMail();
                    App.setRoot("EmojiSection");
                }
            }
        } catch (Exception e) {
            System.out.println("INTENTE DE NUEVO");
        }

    }

    @FXML
    private void GuessMethod() throws IOException {
        userName = "Guess";
        email = "Guess@guess.com";
        App.setRoot("EmojiSection");
    }
    
    public static String getUserName(){
        return userName;
    }
    
    public static String getEmail(){
        return email;
    }

}
