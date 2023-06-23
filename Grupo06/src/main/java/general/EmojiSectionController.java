/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
    
    private Image defaultIconFace;
    private Image hoverIconFace;
    
    private Image defaultIconEyes;
    private Image hoverIconEyes;
    
    private Image defaultIconMouth;
    private Image hoverIconMouth;
    
    private Image defaultIconEyeBrows;
    private Image hoverIconEyeBrows;
    
    private Image defaultIconAccessories;
    private Image hoverIconAccessories;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //funcionalidad cambio de color del icono face al poner el mouse encima del boton face
        defaultIconFace = new Image(getClass().getResource("/resources/DefaultIconFace.png").toExternalForm());
        hoverIconFace = new Image(getClass().getResource("/resources/HoverIconFace.png").toExternalForm());
        btFacce.getStyleClass().add("icon-button");
        btFacce.setGraphic(new ImageView(defaultIconFace));
        btFacce.setOnMouseEntered(event -> btFacce.setGraphic(new ImageView(hoverIconFace)));
        btFacce.setOnMouseExited(event -> btFacce.setGraphic(new ImageView(defaultIconFace)));
        
        //funcionalidad cambio de color del icono eyes al poner el mouse encima del boton eyes
        defaultIconEyes = new Image(getClass().getResource("/resources/DefaultIconEyes.png").toExternalForm());
        hoverIconEyes = new Image(getClass().getResource("/resources/HoverIconEyes.png").toExternalForm());
        btEyes.getStyleClass().add("icon-button");
        btEyes.setGraphic(new ImageView(defaultIconEyes));
        btEyes.setOnMouseEntered(event -> btEyes.setGraphic(new ImageView(hoverIconEyes)));
        btEyes.setOnMouseExited(event -> btEyes.setGraphic(new ImageView(defaultIconEyes)));
        
        //funcionalidad cambio de color del icono Mouth al poner el mouse encima del boton Mouth
        defaultIconMouth = new Image(getClass().getResource("/resources/DefaultIconMouth.png").toExternalForm());
        hoverIconMouth = new Image(getClass().getResource("/resources/HoverIconMouth.png").toExternalForm());
        btMouth.getStyleClass().add("icon-button");
        btMouth.setGraphic(new ImageView(defaultIconMouth));
        btMouth.setOnMouseEntered(event -> btMouth.setGraphic(new ImageView(hoverIconMouth)));
        btMouth.setOnMouseExited(event -> btMouth.setGraphic(new ImageView(defaultIconMouth)));
        
        //funcionalidad cambio de color del icono eyebrows al poner el mouse encima del boton eyebrows
        defaultIconEyeBrows = new Image(getClass().getResource("/resources/DefaultIconEyeBrows.png").toExternalForm());
        hoverIconEyeBrows = new Image(getClass().getResource("/resources/HoverIconEyeBrows.png").toExternalForm());
        btEyesBrows.getStyleClass().add("icon-button");
        btEyesBrows.setGraphic(new ImageView(defaultIconEyeBrows));
        btEyesBrows.setOnMouseEntered(event -> btEyesBrows.setGraphic(new ImageView(hoverIconEyeBrows)));
        btEyesBrows.setOnMouseExited(event -> btEyesBrows.setGraphic(new ImageView(defaultIconEyeBrows)));
        
        //funcionalidad cambio de color del icono accessories al poner el mouse encima del boton accessories
        defaultIconAccessories = new Image(getClass().getResource("/resources/DefaultIconAccessories.png").toExternalForm());
        hoverIconAccessories = new Image(getClass().getResource("/resources/HoverIconAccessories.png").toExternalForm());
        btAccessories.getStyleClass().add("icon-button");
        btAccessories.setGraphic(new ImageView(defaultIconAccessories));
        btAccessories.setOnMouseEntered(event -> btAccessories.setGraphic(new ImageView(hoverIconAccessories)));
        btAccessories.setOnMouseExited(event -> btAccessories.setGraphic(new ImageView(defaultIconAccessories)));
        
    }
    
    @FXML
    private void closeWindow() throws IOException {
        System.exit(0);
    }
    
    @FXML
    private void LogOutMethod() throws IOException{
        App.setRoot("Login");
    }
    
}
