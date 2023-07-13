/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import TDAs.ArrayList;
import TDAs.DoubleCircularList;
import TDAs.List;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modules.Emoji;
import modules.Component;
import modules.History;
import modules.Library;
import modules.Profile;
import utils.Alertas;
import utils.Resource;
import utils.Serialization;

/**
 * FXML Controller class
 *
 * @author Jorge Daniel
 */
public class EmojiSectionController implements Initializable {

    @FXML
    private Button BtDeleate;

    @FXML
    private Button BtUpload;

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
    private ImageView imgSelect;

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
    private StackPane SPEmoji = new StackPane();

    @FXML
    private HBox HBoxEmojis;

    @FXML
    private Button forward;

    @FXML
    private Button back;

    @FXML
    private Button bttonSave;

    @FXML
    private GridPane GpDirect;

    @FXML
    private RadioButton RBdirect;

    @FXML
    private RadioButton RBsequential;

    @FXML
    private ScrollPane SpEmoji;

    private ToggleGroup group;

    private final Alertas alert = new Alertas();

    private final FileChooser fc = new FileChooser();

    public static ImageView viewAccessory = new ImageView();
    public static ImageView viewFace = new ImageView();
    public static ImageView viewEyes = new ImageView();
    public static ImageView viewEyebrows = new ImageView();
    public static ImageView viewMouth = new ImageView();

    public static History history;
    public static Resource currentComponents;

    static Profile profile;

    private void initializeIcon(String iconPathDefault, String iconPathHover, Button button) {

        int pathLength = iconPathDefault.length();
        Resource resources = new Resource(iconPathHover.substring(20, pathLength - 6));
        Image defaultIcon = new Image(getClass().getResource(iconPathDefault).toExternalForm());
        Image hoverIcon = new Image(this.getClass().getResource(iconPathHover).toExternalForm());
        button.getStyleClass().add("icon-button");
        button.setGraphic(new ImageView(defaultIcon));
        button.setOnMouseEntered(event -> button.setGraphic(new ImageView(hoverIcon)));
        button.setOnMouseExited(event -> button.setGraphic(new ImageView(defaultIcon)));

        Image imgDefault = new Image(Paths.get("userData/defaultImage.png").toAbsolutePath().toUri().toString());
        resources.getResourcesList().addFirst(imgDefault);

        if (!profile.getName().equals("Guest")) {
            resources.getResourcesList().addAll(profile.loadUserComponents(resources.getType().name().toLowerCase()));
        }

        button.setOnAction(event -> {
            if (RBsequential.isSelected()) {
                loadEmojiSequential(resources);
            } else {
                loadEmojiDirect(resources);
            }
        });
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SPEmoji.getChildren().addAll(viewFace, viewEyes, viewEyebrows,
                viewMouth, viewAccessory);
        history = new History(new Emoji(viewEyes, viewMouth,
                viewFace, viewEyebrows, viewAccessory));

        initializeIcon("/resources/DefaultIconFaces.png", "/resources/HoverIconFaces.png", btFacce);
        initializeIcon("/resources/DefaultIconEyes.png", "/resources/HoverIconEyes.png", btEyes);
        initializeIcon("/resources/DefaultIconEyeBrows.png", "/resources/HoverIconEyeBrows.png", btEyesBrows);
        initializeIcon("/resources/DefaultIconMouth.png", "/resources/HoverIconMouth.png", btMouth);
        initializeIcon("/resources/DefaultIconAccessories.png", "/resources/HoverIconAccessories.png", btAccessories);

        //Inizialize gridpane false and panebar true
        SpEmoji.setVisible(false);
        PaneBar.setVisible(true);
        ImgArrowL.setVisible(true);
        ImgArrowR.setVisible(true);
        imgSelect.setVisible(true);

        //Make ImageView draggable
        makeResizableAndDraggable(viewEyes);
        makeResizableAndDraggable(viewAccessory);
        makeResizableAndDraggable(viewEyebrows);
        makeResizableAndDraggable(viewFace);
        makeResizableAndDraggable(viewMouth);

        if (!profile.getName().equals("Guest")) {
            BtDeleate.setDisable(false);
        }

    }

    @FXML
    private void closeWindow() throws IOException {
        Serialization.serialize(Profile.arrayProfile, "profile");
        System.exit(0);
    }

    @FXML
    private void LogOutMethod() throws IOException {
        App.setRoot("Login");
    }

    @FXML
    void uploadImageResource() {
        if (profile.getName().equals("Guest")) {
            alert.AlertInfo("You must log in to perform this action");
        } else if (currentComponents == null) {
            alert.AlertInfo("xd");
        } else {
            FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("Imagen PNG", "*.png");
            FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("Imagen JPG", "*.jpg");
            FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("Imagen JPEG", "*.jpeg");
            fc.getExtensionFilters().addAll(pngFilter, jpegFilter, jpgFilter);

            File file = fc.showOpenDialog(new Stage());
            if (file != null && file.isFile()) {

                try {
                    String imagePath = file.getCanonicalPath();

                    profile.saveUserComponent(imagePath, currentComponents.getType().name().toLowerCase());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                alert.AlertInfo("No image selected");
            }

            List<Image> userComponents = profile.loadUserComponents(currentComponents.getType().name().toLowerCase());

            currentComponents.getResourcesList().addLast(userComponents.get(userComponents.size() - 1));

            if (RBdirect.isSelected()) {
                loadEmojiDirect(currentComponents);
            }
            if (BtDeleate.isDisable()) {
                BtDeleate.setDisable(false);
            }
        }
    }

    @FXML
    public void deleateImageResource() {
        if (currentComponents == null) {
            alert.AlertInfo("xd");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserComponents.fxml"));
            Parent root;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setTitle("User Components Window");
            newStage.setScene(new Scene(root));
            newStage.showAndWait();

            if (RBdirect.isSelected()) {
                loadEmojiDirect(currentComponents);
            }
        }

    }

    @FXML
    private void getNextElement() {
        int sizeHBox = HBoxEmojis.getChildren().size();

        if (sizeHBox > 0) {

            ImageView img = (ImageView) HBoxEmojis.getChildren().get(sizeHBox - 1);
            Image nextImage = currentComponents.getResourcesList().getNext(img.getImage());
            ImageView imgVw = new ImageView(nextImage);
            imgVw.setPreserveRatio(false);
            imgVw.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            imgVw.setFitWidth(HBoxEmojis.getPrefHeight() - 10);
            HBoxEmojis.getChildren().remove(0);
            HBoxEmojis.getChildren().add(sizeHBox - 1, imgVw);
            showEmoji();

        }

    }

    @FXML
    private void getPreviousElement() {
        int sizeHBox = HBoxEmojis.getChildren().size();

        if (sizeHBox > 0) {

            ImageView img = (ImageView) HBoxEmojis.getChildren().get(0);
            Image nextImage = currentComponents.getResourcesList().getPrevious(img.getImage());
            ImageView imgVw = new ImageView(nextImage);
            imgVw.setPreserveRatio(false);
            imgVw.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            imgVw.setFitWidth(HBoxEmojis.getPrefHeight() - 10);
            HBoxEmojis.getChildren().remove(sizeHBox - 1);
            HBoxEmojis.getChildren().add(0, imgVw);
            showEmoji();

        }

    }

    private void loadEmojiSequential(Resource resource) {

        HBoxEmojis.getChildren().clear();
        currentComponents = resource;
//        if (!profile.getName().equals("Guest")) {
//            currentComponents.getResourcesList().union(profile.loadUserComponents(currentComponents.getType().name().toLowerCase()));
//        }

        for (int i = 0; i < 9; i++) {

            ImageView img = new ImageView(resource.getResourcesList().get(i));
            img.setPreserveRatio(false);
            img.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            img.setFitWidth(HBoxEmojis.getPrefHeight() - 10);

            HBoxEmojis.getChildren().addAll(img);

        }
        showEmoji();
    }

    private void loadEmojiDirect(Resource resource) {
        GpDirect.getChildren().clear();
        currentComponents = resource;
//        if (!profile.getName().equals("Guest")) {
//            currentComponents.getResourcesList().union(profile.loadUserComponents(currentComponents.getType().name().toLowerCase()));
//        }

        int columns = 0;
        int rows = 0;

        int gpRows = GpDirect.getRowCount();
        for (int i = 0; i < resource.getResourcesList().size(); i++) {
            ImageView img = new ImageView(resource.getResourcesList().get(i));
            img.setPreserveRatio(false);
            img.setFitHeight(HBoxEmojis.getPrefHeight() - 10);
            img.setFitWidth(HBoxEmojis.getPrefHeight() - 10);

            if (img.getImage().getUrl().contains("defaultImage.png")) {
                img.setOnMouseClicked(ev -> {
                   updateEmoji(currentImageView(), null);
                });

                
            } else {

                img.setOnMouseClicked(ev -> {
                    updateEmoji(currentImageView(), img.getImage());
                });
            }

            GpDirect.add(img, columns, rows);
            if (columns < 8) {
                columns++;
            } else {
                columns = 0;
                rows++;
                if (rows > gpRows - 1) {
                    GpDirect.addRow(rows - 1);
                }
            }

        }

    }

    private void showEmoji() {

        ImageView img = (ImageView) HBoxEmojis.getChildren().get(4);
        Image image = img.getImage();
        ImageView imgVw = currentImageView();
        if (image.getUrl().contains("defaultImage.png")) {
            updateEmoji(imgVw, null);
        } else {
            imgVw.setFitHeight(150);
            imgVw.setFitWidth(150);
            updateEmoji(imgVw, image);
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
        if (emoji != null) {
            updateImageView(emoji.getAccessoriesComponent(), viewAccessory);
            updateImageView(emoji.getEyeComponent(), viewEyes);
            updateImageView(emoji.getFaceComponent(), viewFace);
            updateImageView(emoji.getMouthComponent(), viewMouth);
            updateImageView(emoji.getEyesbrowsComponent(), viewEyebrows);
        }
    }

    @FXML
    public void goBack() {

        Emoji emoji = history.back();
        if (emoji != null) {
            updateImageView(emoji.getAccessoriesComponent(), viewAccessory);
            updateImageView(emoji.getEyeComponent(), viewEyes);
            updateImageView(emoji.getFaceComponent(), viewFace);
            updateImageView(emoji.getMouthComponent(), viewMouth);
            updateImageView(emoji.getEyesbrowsComponent(), viewEyebrows);
        }
    }

    public static void updateImageView(Component comp, ImageView imgV) {
        imgV.setImage(Emoji.toImage(comp.getPath()));
        imgV.setTranslateX(comp.getPositionX());
        imgV.setTranslateY(comp.getPositionY());
        imgV.setFitHeight(comp.getHeight());
        imgV.setFitWidth(comp.getWidth());
    }

    public void updateEmoji(ImageView imgV, Image img) {

        imgV.setImage(img);
        Emoji e = new Emoji(viewEyes, viewMouth, viewFace,
                viewEyebrows, viewAccessory);

        history.setActual(e);

    }

    @FXML
    public void exportImage() {
        fc.setInitialFileName("Emoji(" + LocalTime.now().toString().substring(0, 8) + ")");
        FileChooser.ExtensionFilter filesFilter = new FileChooser.ExtensionFilter("Carpetas", "*.");
        fc.getExtensionFilters().add(filesFilter);
        File file = fc.showSaveDialog(new Stage());
        if (file != null) {
            System.out.println("xddddd");
            try {
                String filePath = file.getCanonicalPath();
                System.out.println(filePath);
                ProjectController.exportStackPaneAsImage(SPEmoji, filePath + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void saveProject() {
        if (profile.getName().equals("Guest")) {
            alert.AlertInfo("You must log in to perform this action");
        } else {
            Emoji actualEmoji = history.getActual();

            if (profile.getLibrary().getUserEmoji().contains(actualEmoji)) {
                alert.AlertError("Cannot save the same project");
            } else if (actualEmoji != null) {
                String path = "userData/profiles/" + profile.getMail() + "/project" + profile.getLibrary().getUserEmoji().size() + ".png";
                ProjectController.exportStackPaneAsImage(SPEmoji, path);
           
                actualEmoji.setCurrentEmojiPath(path);

                System.out.println(actualEmoji.getCurrentEmojiPath());

                List<Emoji> lb = profile.getLibrary().getUserEmoji();
                lb.addLast(actualEmoji);

                System.out.println(profile.getLibrary().getUserEmoji());
            }

        }
    }

    @FXML
    public void showSequentialOrDirect() {
        if (RBsequential.isSelected()) {

            SpEmoji.setVisible(false);
            PaneBar.setVisible(true);
            ImgArrowL.setVisible(true);
            ImgArrowR.setVisible(true);
            imgSelect.setVisible(true);
        } else if (RBdirect.isSelected()) {
            SpEmoji.setVisible(true);
            PaneBar.setVisible(false);
            ImgArrowL.setVisible(false);
            ImgArrowR.setVisible(false);
            imgSelect.setVisible(false);

        }
    }

    @FXML
    private void openProfile() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Profile window");
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    //método para hacer la imagen redimensionar y arrastrar una imagen
    private void makeResizableAndDraggable(ImageView imageView) {

        double minX = 50;
        double minY = 50;
        double maxX = 250;
        double maxY = 250;

        Delta dragDelta = new Delta();
        ResizeData resizeData = new ResizeData();

        imageView.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown()) {
                dragDelta.x = imageView.getBoundsInParent().getWidth() - event.getX();
                dragDelta.y = imageView.getBoundsInParent().getHeight() - event.getY();
                imageView.setCursor(Cursor.SE_RESIZE);
                resizeData.isResizing = true;
                event.consume();
            } else {
                dragDelta.x = event.getSceneX() - imageView.getTranslateX();
                dragDelta.y = event.getSceneY() - imageView.getTranslateY();
                imageView.setCursor(Cursor.MOVE);
                event.consume();
            }
        });

        imageView.setOnMouseReleased(event -> {
            imageView.setCursor(Cursor.DEFAULT);
            resizeData.isResizing = false;
            event.consume();
            System.out.println(imageView.getFitHeight() + "; " + imageView.getFitWidth());
            System.out.println(imageView.getImage().getHeight() + ";" + imageView.getImage().getWidth());
            System.out.println(imageView.getTranslateX() + "; " + imageView.getTranslateY());
            updateEmoji(imageView, imageView.getImage());
        });

        imageView.setOnMouseDragged(event -> {
            if (resizeData.isResizing) {
                double newX = event.getX() + dragDelta.x;
                double newY = event.getY() + dragDelta.y;

                if (newX > minX && newX < maxX) {
                    imageView.setFitWidth(newX);
                }

                if (newY > minY && newY < maxY) {
                    imageView.setFitHeight(newY);
                }
            } else {

                imageView.setTranslateX(event.getSceneX() - dragDelta.x);
                imageView.setTranslateY(event.getSceneY() - dragDelta.y);
            }
            if (imageView.getBoundsInParent().getMaxX() > 293 || imageView.getBoundsInParent().getMaxY() > 268 || imageView.getBoundsInParent().getMinX() < -5 || imageView.getBoundsInParent().getMinY() < -5) {
                // Set the position to (0,0)
                imageView.setTranslateX(0);
                imageView.setTranslateY(0);
            }
            event.consume();
        });

        imageView.setOnMouseEntered(event -> {
            if (!event.isPrimaryButtonDown()) {
                imageView.setCursor(Cursor.DEFAULT);
            }
        });

        imageView.setOnMouseExited(event -> {
            if (!event.isPrimaryButtonDown()) {
                imageView.setCursor(Cursor.DEFAULT);
            }
        });

    }

    //Clase estática que almacena las coordenadas x, y del desplazamiento de un evento de ratón respecto a la imagen.
    private static class Delta {

        double x;
        double y;
    }

    //Clase estática que tiene un atributo booleano que se utiliza para indicar si se está redimensionando la imagen.
    private static class ResizeData {

        boolean isResizing;
    }

}
