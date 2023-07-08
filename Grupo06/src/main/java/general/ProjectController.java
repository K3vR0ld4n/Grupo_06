/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

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
    
    Alertas alert = new Alertas();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadProjectsDefault(GpProject);
        
    }
    
    @FXML
    private void selectMethod(){
        alert.AlertConfirmation("Are you sure you want to load this emoji?");
        Stage currentStage = (Stage) BtSelect.getScene().getWindow();
        currentStage.close();
        
        // CODIGO AL PRESIONAR EL BOTON SELECT
    }
    
    private void loadProjectsDefault(GridPane gp){
        int columns = gp.getColumnCount();
        int rows = gp.getRowCount();
        int countC = 0;
        int countR = 0;
        
        if(Library.defaultEmoji.size() > 0){
            
            for(Emoji e: Library.defaultEmoji){
                StackPane SPEmoji = new StackPane();
                
                ImageView accesory = new ImageView();
                accesory.setImage(e.getAccessories());
                ImageView face = new ImageView();
                face.setImage(e.getFace());
                ImageView eyes = new ImageView();
                eyes.setImage(e.getEyes());
                ImageView eyebrow = new ImageView();
                eyebrow.setImage(e.getEyesbrows());
                ImageView mouth = new ImageView();
                mouth.setImage(e.getMouth());
                SPEmoji.getChildren().addAll(face,eyes,eyebrow, mouth, accesory);
                
                if(countC < columns){
                    gp.add(SPEmoji, countC, countR);
                    countC++;
                }
                else if(countR < rows){
                    countR++;
                    gp.add(SPEmoji, countC, countR);
                }
                else if(countR == rows){
                    gp.addRow(1);
                    gp.add(SPEmoji, countC, countR);
                    countR++;
                }
                
            }
        }
    }
    
}
