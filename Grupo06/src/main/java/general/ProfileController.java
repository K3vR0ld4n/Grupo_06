/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import static general.EmojiSectionController.profile;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Alertas;

/**
 * FXML Controller class
 *
 * @author Jorge Daniel
 */
public class ProfileController implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnProjects;

    @FXML
    private Button btnLogout;

    private final Alertas alert = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(EmojiSectionController.profile.getName());
        System.out.println(EmojiSectionController.profile.getMail());
        txtName.setText(EmojiSectionController.profile.getName());
        txtEmail.setText(EmojiSectionController.profile.getMail());
    }

    @FXML
    private void logOutMethod() throws IOException {
        Stage currentStage = (Stage) btnLogout.getScene().getWindow();
        currentStage.close();
        App.setRoot("Login");
    }

    @FXML
    private void openProjects() {
        if (EmojiSectionController.profile.getName().equals("Guest")) {
            alert.AlertInfo("You must log in to perform this action");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Project.fxml"));
            Parent root;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setTitle("Project Window");
            newStage.setScene(new Scene(root));
            newStage.show();
            //close actual window
            Stage currentStage = (Stage) btnLogout.getScene().getWindow();
            currentStage.close();
        }
    }

}
