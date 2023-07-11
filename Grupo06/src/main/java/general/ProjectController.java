/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import TDAs.ArrayList;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modules.Emoji;
import modules.Library;
import modules.Profile;
import utils.Alertas;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.embed.swing.SwingFXUtils;
import utils.Resource;

public class ProjectController implements Initializable {

    @FXML
    private GridPane GpProject;

    @FXML
    private Button BtSelect;

    @FXML
    private Button btDelete;

    @FXML
    private Button btClearAll;

    private Emoji selectedEmoji;

    private final Alertas alert = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedEmoji = new Emoji();
        loadProjects(GpProject, Library.defaultEmoji);
        loadProjects(GpProject, EmojiSectionController.profile.getLibrary().getUserEmoji());

    }

    @FXML
    private void selectMethod() {
        boolean b = alert.AlertConfirmation("Are you sure you want to LOAD this emoji?");
        if (b) {
            EmojiSectionController.updateImageView(selectedEmoji.getAccessoriesComponent(), EmojiSectionController.viewAccessory);
            EmojiSectionController.updateImageView(selectedEmoji.getEyeComponent(), EmojiSectionController.viewEyes);
            EmojiSectionController.updateImageView(selectedEmoji.getFaceComponent(), EmojiSectionController.viewFace);
            EmojiSectionController.updateImageView(selectedEmoji.getEyesbrowsComponent(), EmojiSectionController.viewEyebrows);
            EmojiSectionController.updateImageView(selectedEmoji.getMouthComponent(), EmojiSectionController.viewMouth);
            Stage currentStage = (Stage) BtSelect.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    private void deleteMethod(){
        boolean b = alert.AlertConfirmation("Are you sure you want to DELETE this emoji?");
        if (b) {
            System.out.println("EMOJI 0 "+EmojiSectionController.profile.getLibrary().getUserEmoji().get(0).getCurrentEmojiPath());
            System.out.println("EMOJI 1"+EmojiSectionController.profile.getLibrary().getUserEmoji().get(1).getCurrentEmojiPath());
            EmojiSectionController.profile.getLibrary().getUserEmoji().remove(selectedEmoji);
            System.out.println(selectedEmoji.getCurrentEmojiPath());
            Resource.deleteFilePath(selectedEmoji.getCurrentEmojiPath());
            Resource.deleteFilePath("target/classes"+selectedEmoji.getCurrentEmojiPath().substring(18));
            Stage currentStage = (Stage) btDelete.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    private void clearAllMethod() {

    }

    private void loadProjects(GridPane gp, ArrayList<Emoji> l) {
        int columns = gp.getColumnCount();
        int rows = gp.getRowCount();
        int countC = 0;
        int countR = 0;

        if (l.size() > 0) {
            System.out.println(l);

            for (Emoji e : l) {//arreglar uwu
                if (e != null) { // Add a null check for the Emoji object
                    StackPane SPEmoji = new StackPane();
                    ImageView imgV = new ImageView();
                    Image im = new Image(getClass().getResource(e.getCurrentEmojiPath().substring(18)).toExternalForm());
                    imgV.setImage(im);
                    imgV.setFitHeight(70);
                    imgV.setFitWidth(70);

                    SPEmoji.getChildren().addAll(imgV);
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

    public static void exportStackPaneAsImage(StackPane stackPane, String filePath) {
        WritableImage snapshot = stackPane.snapshot(new SnapshotParameters(), null);
        File file = new File(filePath);
        File file2 = new File("target/classes/" + filePath.substring(18));
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
