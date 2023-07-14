/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import TDAs.ArrayList;
import TDAs.DoubleCircularList;
import TDAs.List;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modules.Emoji;
import modules.Library;
import utils.Alertas;
import utils.Resource;

/**
 *
 * @author lancervs
 */
public class DefaultEmojiController implements Initializable {

    @FXML
    private GridPane GpDefault;

    @FXML
    private ScrollPane SpDefault;

    @FXML
    private Button bttSelect;

    private Emoji selectedEmoji;

    private final Alertas alert = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Emoji> defaultEmojis = Library.defaultEmoji;
        loadProjects(GpDefault, defaultEmojis);
    }

    @FXML
    private void selectDefault() {
        if (selectedEmoji == null) {
            alert.AlertInfo("You must to select a Emoji");
        } else if (alert.AlertConfirmation("Are you sure you want to LOAD this emoji?")) {
            EmojiSectionController.history.clear();
            EmojiSectionController.updateImageView(selectedEmoji.getAccessoriesComponent(), EmojiSectionController.viewAccessory);
            EmojiSectionController.updateImageView(selectedEmoji.getEyeComponent(), EmojiSectionController.viewEyes);
            EmojiSectionController.updateImageView(selectedEmoji.getFaceComponent(), EmojiSectionController.viewFace);
            EmojiSectionController.updateImageView(selectedEmoji.getEyesbrowsComponent(), EmojiSectionController.viewEyebrows);
            EmojiSectionController.updateImageView(selectedEmoji.getMouthComponent(), EmojiSectionController.viewMouth);
            Stage currentStage = (Stage) bttSelect.getScene().getWindow();
            currentStage.close();
        }

    }

    private void loadProjects(GridPane gp, List<Emoji> l) {
        int rows = gp.getRowCount();
        int countC = 0;
        int countR = 0;

        if (l.size() > 0) {
            System.out.println(l);

            for (Emoji e : l) {

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
            }

        }
    }

}
