package general;
import TDAs.ArrayList;
import modules.*;

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
    private void switchToRegister() throws IOException{
        App.setRoot("Register");
    }
    
    @FXML
    private void closeWindow() throws IOException{
        System.exit(0);
    }
    
    @FXML
    private void logIn(){
        try{
            String nameInput = this.Txtname.getText();
            String passwordInput = this.TxtPasword.getText();
      
            for(Profile p: Profile.arrayProfile){
                if(nameInput.equals(p.getName()) && passwordInput.equals(p.getPassword())){
                    System.out.println("INICIO DE SESION CORRECTO");
                    return;
                 }
            }
        }catch(Exception e){
            System.out.println("INTENTE DE NUEVO");
        }
       
    }
    
    
}