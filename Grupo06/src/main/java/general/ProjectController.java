/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import TDAs.ArrayList;
import TDAs.List;
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
import java.util.Iterator;
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

        loadProjects(GpProject, Library.defaultEmoji);
        loadProjects(GpProject, EmojiSectionController.profile.getLibrary().getUserEmoji());

    }

    @FXML
    private void selectMethod() {

        if (selectedEmoji == null) {
            alert.AlertInfo("You must to select a Emoji");
        } else if (alert.AlertConfirmation("Are you sure you want to LOAD this emoji?")) {
            EmojiSectionController.updateImageView(selectedEmoji.getAccessoriesComponent(), EmojiSectionController.viewAccessory);
            EmojiSectionController.updateImageView(selectedEmoji.getEyeComponent(), EmojiSectionController.viewEyes);
            EmojiSectionController.updateImageView(selectedEmoji.getFaceComponent(), EmojiSectionController.viewFace);
            EmojiSectionController.updateImageView(selectedEmoji.getEyesbrowsComponent(), EmojiSectionController.viewEyebrows);
            EmojiSectionController.updateImageView(selectedEmoji.getMouthComponent(), EmojiSectionController.viewMouth);
            EmojiSectionController.history.clear();
            Stage currentStage = (Stage) BtSelect.getScene().getWindow();
            currentStage.close();
        }

    }

    @FXML
    private void deleteMethod() {
        if (selectedEmoji == null) {
            alert.AlertInfo("You must to select a Emoji");
        } else if (alert.AlertConfirmation("Are you sure you want to DELETE this Emoji?")) {
            System.out.println(selectedEmoji.getCurrentEmojiPath());

            EmojiSectionController.profile.getLibrary().getUserEmoji().remove(selectedEmoji);

            System.out.println(selectedEmoji.getCurrentEmojiPath());

            Resource.deleteFilePath(selectedEmoji.getCurrentEmojiPath());

            Stage currentStage = (Stage) btDelete.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    private void clearAllMethod() {

        if (alert.AlertConfirmation("Are you sure you want to DELETE ALL PROJECTS?")) {

            List<Emoji> emoji = EmojiSectionController.profile.getLibrary().getUserEmoji();

            Iterator<Emoji> itr = EmojiSectionController.profile.getLibrary().getUserEmoji().iterator();
            int count = 0;

            while (count < emoji.size()) {
                Resource.deleteFilePath(itr.next().getCurrentEmojiPath());
                count++;
            }

            emoji.clear();

            Stage currentStage = (Stage) btDelete.getScene().getWindow();
            currentStage.close();
        }
    }

    private void loadProjects(GridPane gp, List<Emoji> l) {
        //int columns = gp.getColumnCount();
        int rows = gp.getRowCount();
        int countC = 0;
        int countR = 0;

        Iterator<Emoji> itr = l.iterator();
        boolean iterable = true;
        int count = 0;

        if (l.size() > 0) {
            System.out.println(l);

            while (iterable) {
                Emoji e = itr.next();
                if (e != null) {
                    if (count == l.size()) {
                        iterable = false;
                    } else {
                        System.out.println(e.getCurrentEmojiPath());
                        StackPane SPEmoji = new StackPane();
                        SPEmoji.getStyleClass().add("stackpaneCss");
                        ImageView imgV = new ImageView();

                        Image im = new Image(Paths.get(e.getCurrentEmojiPath()).toAbsolutePath().toUri().toString());
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
                        SPEmoji.setOnMouseClicked(event -> {
                            selectedEmoji = e;
                            System.out.println(SPEmoji.getChildren());
                        });
                        count++;
                    }

                }
            }

        }
    }

    public static void exportStackPaneAsImage(StackPane stackPane, String filePath) {

        WritableImage snapshot = stackPane.snapshot(new SnapshotParameters(), null);
        File file = new File(filePath);
        //File file2 = new File("target/classes/" + filePath.substring(18));

        try {

            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
            // ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
