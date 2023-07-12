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

/**
 *
 * @author kev-roldan
 */
public class Library implements Serializable{
    public static  ArrayList<Emoji> defaultEmoji=loadDefaults();
    private List<Emoji> userEmoji;
   // private transient ArrayList<Image> userComponents;
    private ArrayList<String> userComponentsPaths;

    public Library() {
        this.userEmoji = new DoubleCircularList<>();
        //this.userComponents=new ArrayList<>();
        this.userComponentsPaths = new ArrayList<>();
    }

    public ArrayList<String> getUserComponentsPaths() {
        return userComponentsPaths;
    }

//
//    public ArrayList<Image> getUserComponents() {
//        return userComponents;
//    }

//    public void setUserComponents(ArrayList<Image> userComponents) {
//        this.userComponents = userComponents;
//    }

    public List<Emoji> getUserEmoji() {
        return userEmoji;
    }

    public boolean addEmoji(Emoji emoji){
        return false;
    }
    
    private static ArrayList<Emoji> loadDefaults(){
        ArrayList<Emoji> newArray = new ArrayList<>();
        return newArray;
    }
    
    
    
} 
