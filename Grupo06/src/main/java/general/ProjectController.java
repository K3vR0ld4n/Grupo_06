/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import TDAs.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modules.Emoji;
import modules.Library;
import modules.Profile;
import utils.Alertas;

public class ProjectController implements Initializable {

    @FXML
    private GridPane GpProject;

    @FXML
    private Button BtSelect;

    private final Alertas alert = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadProjects(GpProject, Library.defaultEmoji);
        loadProjects(GpProject, EmojiSectionController.profile.getLibrary().getUserEmoji());
    }

    @FXML
    private void selectMethod() {
        alert.AlertConfirmation("Are you sure you want to load this emoji?");
        Stage currentStage = (Stage) BtSelect.getScene().getWindow();
        currentStage.close();
        
        
        
        // CODIGO AL PRESIONAR EL BOTON SELECT
        
        
        
        
    }

    private void loadProjects(GridPane gp, ArrayList<Emoji> l) {
        int columns = gp.getColumnCount();
        int rows = gp.getRowCount();
        int countC = 0;
        int countR = 0;

        if (l.size() > 0) {
            System.out.println(l);

            for (Emoji e : l) {
                if (e != null) { // Add a null check for the Emoji object
                    StackPane SPEmoji = new StackPane();

                    ImageView accessory = new ImageView();
                    if (e.haveAccessories()) {
                        accessory.setImage(Emoji.toImage(e.getAccessoriesPath()));
                        accessory.setFitHeight(60);accessory.setFitWidth(60);
                    }
                    ImageView face = new ImageView();
                    if (e.haveFace()) {
                        face.setImage(Emoji.toImage(e.getFacePath()));
                        face.setFitHeight(60);face.setFitWidth(60);
                    }
                    ImageView eyes = new ImageView();
                    if (e.haveEyes()) {
                        eyes.setImage(Emoji.toImage(e.getEyesPath()));
                        eyes.setFitHeight(60);eyes.setFitWidth(60);
                    }
                    ImageView eyebrow = new ImageView();
                    if (e.haveEyeBrows()) {
                        eyebrow.setImage(Emoji.toImage(e.getEyesbrowsPath()));
                        eyebrow.setFitHeight(60);eyebrow.setFitWidth(60);
                    }
                    ImageView mouth = new ImageView();
                    if (e.haveMouth()) {
                        mouth.setImage(Emoji.toImage(e.getMouthPath()));
                        mouth.setFitHeight(60);mouth.setFitWidth(60);
                    }
                    SPEmoji.getChildren().addAll(face, eyes, eyebrow, mouth, accessory);
                    gp.add(SPEmoji, countC, countR);
                    if (countC < 5) {
                        countC++;
                    } else {
                        countC = 0;
                        countR++;
                        if (countR > rows - 1) {
                            gp.addRow(countR - 1);
                        }
                    }


                }
            }
        }
    }

}
