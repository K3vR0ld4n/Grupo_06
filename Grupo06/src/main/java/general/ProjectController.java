/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package general;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.Alertas;


public class ProjectController implements Initializable {

    @FXML
    private GridPane GpProject;
    
    @FXML
    private Button BtSelect;
    
    Alertas alert = new Alertas();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void selectMethod(){
        alert.AlertConfirmation("Are you sure you want to load this emoji?");
        Stage currentStage = (Stage) BtSelect.getScene().getWindow();
        currentStage.close();
        
        // CODIGO AL PRESIONAR EL BOTON SELECT
    }
    
}
