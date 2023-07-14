/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;
import TDAs.DoubleCircularList;
import TDAs.List;
import java.io.Serializable;
import javafx.scene.image.Image;
import utils.Serialization;

/**
 *
 * @author kev-roldan
 */
public class Library implements Serializable {

    public static List<Emoji> defaultEmoji = loadDefaults();
    private List<Emoji> userEmoji;
    // private transient ArrayList<Image> userComponents;
    private List<String> userComponentsPaths;

    public Library() {
        this.userEmoji = new ArrayList<>();
        //this.userComponents=new ArrayList<>();
        this.userComponentsPaths = new ArrayList<>();
    }

    public List<String> getUserComponentsPaths() {
        return userComponentsPaths;
    }

    public List<Emoji> getUserEmoji() {
        return userEmoji;
    }

    public boolean addEmoji(Emoji emoji) {
        return false;
    }

    public static List<Emoji> loadDefaults() {
        List<Emoji> newArray = Serialization.unserialize("defaultEmojis");
        return newArray;
    }
   
}
