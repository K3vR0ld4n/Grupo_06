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

    private Emoji selectedEmoji;

    private final Alertas alert = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedEmoji = new Emoji(null,null,null,null,null);
        loadProjects(GpProject, Library.defaultEmoji);
        loadProjects(GpProject, EmojiSectionController.profile.getLibrary().getUserEmoji());

    }

    @FXML
    private void selectMethod() {
        
        EmojiSectionController.updateImageView(selectedEmoji.getAccessoriesComponent(), EmojiSectionController.viewAccessory);
        EmojiSectionController.updateImageView(selectedEmoji.getEyeComponent(), EmojiSectionController.viewEyes);
        EmojiSectionController.updateImageView(selectedEmoji.getFaceComponent(), EmojiSectionController.viewFace);
        EmojiSectionController.updateImageView(selectedEmoji.getEyesbrowsComponent(), EmojiSectionController.viewEyebrows);
        EmojiSectionController.updateImageView(selectedEmoji.getMouthComponent(), EmojiSectionController.viewMouth);
        
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
                        accessory.setFitHeight(e.getAccessoriesComponent().getHeight() / 4);
                        accessory.setFitWidth(e.getAccessoriesComponent().getWidth()/ 4);
                    }
                    ImageView face = new ImageView();
                    if (e.haveFace()) {
                        face.setImage(Emoji.toImage(e.getFacePath()));
                        face.setFitHeight(e.getFaceComponent().getHeight()/4);
                        face.setFitWidth(e.getFaceComponent().getWidth()/4);
                    }
                    ImageView eyes = new ImageView();
                    if (e.haveEyes()) {
                        eyes.setImage(Emoji.toImage(e.getEyesPath()));
                        eyes.setFitHeight(e.getEyeComponent().getHeight()/4);
                        eyes.setFitWidth(e.getEyeComponent().getWidth()/4);
                    }
                    ImageView eyebrow = new ImageView();
                    if (e.haveEyeBrows()) {
                        eyebrow.setImage(Emoji.toImage(e.getEyesbrowsPath()));
                        eyebrow.setFitHeight(e.getEyesbrowsComponent().getHeight()/4);
                        eyebrow.setFitWidth(e.getEyesbrowsComponent().getWidth()/4);
                    }
                    ImageView mouth = new ImageView();
                    if (e.haveMouth()) {
                        mouth.setImage(Emoji.toImage(e.getMouthPath()));
                        mouth.setFitHeight(e.getMouthComponent().getHeight()/4);
                        mouth.setFitWidth(e.getMouthComponent().getWidth()/4);
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
//                    
                    SPEmoji.setOnMouseClicked(event -> {
                        selectedEmoji = e;
                        System.out.println(SPEmoji.getChildren());
                    });
                }
            }
        }
    }

}
