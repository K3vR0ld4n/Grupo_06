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

public class UserComponentsController implements Initializable {

    @FXML
    private GridPane GpComponents;

    @FXML
    private ScrollPane SpImages;

    @FXML
    private Button btClearAllImages;

    @FXML
    private Button btDeleteImages;

    private String selectedPath;
    private final Alertas alert = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<String> components = EmojiSectionController.profile.getLibrary().getUserComponentsPaths();
        loadProjects(GpComponents, loadCurrentUploadComponents(components, EmojiSectionController.currentComponents.getType().name().toLowerCase()));
    }

    @FXML
    void clearAllImages() {
        if (alert.AlertConfirmation("Are you sure you want to DELETE ALL COMPONENTS?")) {

            List<String> components = EmojiSectionController.profile.getLibrary().getUserComponentsPaths();

            for (String path : components) {
                Resource.deleteFilePath(path);
                //Resource.deleteFilePath("target/classes" + em.getCurrentEmojiPath().substring(18));
            }

            components.clear();

            Stage currentStage = (Stage) btDeleteImages.getScene().getWindow();
            currentStage.close();
        }

    }

    @FXML
    void deleteImages() {
        if (selectedPath == null) {
            alert.AlertInfo("You must to select a Emoji");
        } else if (alert.AlertConfirmation("Are you sure you want to DELETE this Component?")) {

            System.out.println(selectedPath);

            EmojiSectionController.profile.getLibrary().getUserComponentsPaths().remove(selectedPath);

            Resource.deleteFilePath(selectedPath);
            //Resource.deleteFilePath("target/classes" + selectedEmoji.getCurrentEmojiPath().substring(18));

            //borrar el for
            for (Emoji em : EmojiSectionController.profile.getLibrary().getUserEmoji()) {
                System.out.println(em);
            }

            //EmojiSectionController.resetResources();
            DoubleCircularList<Image> list = EmojiSectionController.currentComponents.getResourcesList();

            boolean iterable = true;
            Iterator<Image> itr = list.iterator();

            while (itr.hasNext() && iterable) {
                Image img = itr.next();
                if (img.getUrl().contains(selectedPath)) {

                    list.remove(img);

                    iterable = false;
                }

            }

//            for(Image img: list){
//                String path = img.getUrl();
//                if(path.contains(selectedPath)){
//                    list.remove(img);
//                }
//                
//            }
            Stage currentStage = (Stage) btDeleteImages.getScene().getWindow();
            currentStage.close();
        }

    }

    private ArrayList<String> loadCurrentUploadComponents(List<String> lista, String type) {
        ArrayList<String> toLoad = new ArrayList<>();

        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).contains(type)) {

                    toLoad.addLast(lista.get(i));
                }
            }

        }

        return toLoad;
    }

    private void loadProjects(GridPane gp, ArrayList<String> l) {
        //int columns = gp.getColumnCount();
        int rows = gp.getRowCount();
        int countC = 0;
        int countR = 0;

        if (l.size() > 0) {
            System.out.println(l);

            for (String path : l) {
                System.out.println(path);

                StackPane SPEmoji = new StackPane();
                SPEmoji.getStyleClass().add("stackpaneCss");
                ImageView imgV = new ImageView();

                Image im = new Image(Paths.get(path).toAbsolutePath().toUri().toString());

                //Image im = new Image(getClass().getResource(e.getCurrentEmojiPath().substring(18)).toExternalForm());
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
                    selectedPath = path;
                    System.out.println(SPEmoji.getChildren());
                });
            }

        }
    }

}
