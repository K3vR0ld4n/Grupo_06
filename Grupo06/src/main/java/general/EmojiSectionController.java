/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import TDAs.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import modules.Emoji;
import modules.History;
import utils.Resource;

/**
 * FXML Controller class
 *
 * @author Jorge Daniel
 */
public class EmojiSectionController implements Initializable {

    @FXML
    private Button btFacce;

    @FXML
    private Button btEyes;

    @FXML
    private Button btMouth;

    @FXML
    private Button btEyesBrows;

    @FXML
    private Button btAccessories;

    @FXML
    private ImageView ImgClose;

    @FXML
    private Pane PaneEmoji;

    @FXML
    private Pane PaneOptions;

    @FXML
    private Pane PaneBar;

    @FXML
    private ImageView ImgArrowL;

    @FXML
    private ImageView ImgArrowR;

    @FXML
    private StackPane SPEmoji;

    @FXML
    private HBox HBoxEmojis;

    @FXML
    private ImageView forward;

    @FXML
    private ImageView back;

    private ImageView viewAccessory = new ImageView();
    private ImageView viewFace = new ImageView();
    private ImageView viewEyes = new ImageView();
    private ImageView viewEyebrows = new ImageView();
    private ImageView viewMouth = new ImageView();

    //private Emoji creatingEmoji; //= 
    //History history = new History(creatingEmoji);
    private History history;
    private Resource currentComponents;

    private void initializeIcon(String iconPathDefault, String iconPathHover, Button button) {
        int pathLength = iconPathDefault.length();
        Resource resources = new Resource(iconPathHover.substring(20, pathLength - 6));
        Image defaultIcon = new Image(getClass().getResource(iconPathDefault).toExternalForm());
        Image hoverIcon = new Image(this.getClass().getResource(iconPathHover).toExternalForm());
        button.getStyleClass().add("icon-button");
        button.setGraphic(new ImageView(defaultIcon));
        button.setOnMouseEntered(event -> button.setGraphic(new ImageView(hoverIcon)));
        button.setOnMouseExited(event -> button.setGraphic(new ImageView(defaultIcon)));

        button.setOnAction(event -> loadEmojiSelected(resources));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SPEmoji.getChildren().addAll(viewFace, viewEyes, viewEyebrows, viewMouth, viewAccessory);

        history = new History(new Emoji(viewEyes.getImage(), viewMouth.getImage(), viewFace.getImage(), viewEyebrows.getImage(), viewAccessory.getImage()));

        initializeIcon("/resources/DefaultIconFaces.png", "/resources/HoverIconFaces.png", btFacce);
        initializeIcon("/resources/DefaultIconEyes.png", "/resources/HoverIconEyes.png", btEyes);
        initializeIcon("/resources/DefaultIconEyeBrows.png", "/resources/HoverIconEyeBrows.png", btEyesBrows);
        initializeIcon("/resources/DefaultIconMouth.png", "/resources/HoverIconMouth.png", btMouth);
        initializeIcon("/resources/DefaultIconAccessories.png", "/resources/HoverIconAccessories.png", btAccessories);

    }

    @FXML
    private void closeWindow() throws IOException {
        System.exit(0);
    }

    @FXML
    private void LogOutMethod() throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void getNextElement(MouseEvent event) {
        int sizeHBox = HBoxEmojis.getChildren().size();

        if (sizeHBox > 0) {
            ImageView img = (ImageView) HBoxEmojis.getChildren().get(sizeHBox - 1);
            Image nextImage = currentComponents.getResourcesList().getNext(img.getImage());
            ImageView imgVw = new ImageView(nextImage);
            imgVw.setPreserveRatio(true);
            imgVw.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            HBoxEmojis.getChildren().remove(0);
            HBoxEmojis.getChildren().addAll(imgVw);
            showEmoji();
        }

    }

    @FXML
    private void getPreviousElement(MouseEvent event) {
        int sizeHBox = HBoxEmojis.getChildren().size();

        if (sizeHBox > 0) {
            ImageView img = (ImageView) HBoxEmojis.getChildren().get(0);
            Image nextImage = currentComponents.getResourcesList().getPrevious(img.getImage());
            ImageView imgVw = new ImageView(nextImage);
            imgVw.setPreserveRatio(true);
            imgVw.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            HBoxEmojis.getChildren().remove(sizeHBox - 1);
            HBoxEmojis.getChildren().add(0, imgVw);
            showEmoji();
        }

    }

    private void loadEmojiSelected(Resource resource) {
        HBoxEmojis.getChildren().clear();
        currentComponents = resource;
        for (int i = 0; i < 8; i++) {
            ImageView img = new ImageView(resource.getResourcesList().get(i));
            img.setPreserveRatio(true);
            img.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            HBoxEmojis.getChildren().addAll(img);
        }
        showEmoji();
    }

    private void showEmoji() {

        for (int i = 0; i < 8; i++) {
            ImageView img = (ImageView) HBoxEmojis.getChildren().get(i);
            Image image = img.getImage();
            ImageView imgVw = currentImageView();

            img.setOnMouseClicked(ev -> {
                updateEmoji(imgVw, image);
            });

            imgVw.setPreserveRatio(true);
            imgVw.setFitHeight(SPEmoji.getPrefHeight() - 20);
        }

    }

    private ImageView currentImageView() {
        String type = currentComponents.getType().name();

        switch (type) {
            case "FACES":
                return viewFace;
            case "EYES":
                return viewEyes;
            case "ACCESSORIES":
                return viewAccessory;
            case "EYEBROWS":
                return viewEyebrows;
            case "MOUTH":
                return viewMouth;
            default:
                break;
        }

        return null;
    }

    @FXML
    public void goForward() {
        Emoji emoji = history.advance();
        if(emoji!=null) {
        viewEyes.setImage(emoji.getEyes());
        viewMouth.setImage(emoji.getMouth());
        viewFace.setImage(emoji.getFace());
        viewEyebrows.setImage(emoji.getEyesbrows());
        viewAccessory.setImage(emoji.getAccessories());
        }
    }

    @FXML
    public void goBack() {
        
        Emoji emoji = history.back();
        if(emoji!=null){
        viewEyes.setImage(emoji.getEyes());
        viewMouth.setImage(emoji.getMouth());
        viewFace.setImage(emoji.getFace());
        viewEyebrows.setImage(emoji.getEyesbrows());
        viewAccessory.setImage(emoji.getAccessories());
        }
    }

    public void updateEmoji(ImageView imgV, Image img) {

        imgV.setImage(img);
        Emoji e = new Emoji(viewEyes.getImage(), viewMouth.getImage(), viewFace.getImage(), viewEyebrows.getImage(), viewAccessory.getImage());

        history.setActual(e);


    }
}
