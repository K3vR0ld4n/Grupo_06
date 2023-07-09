/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.Serializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author kev-roldan
 */
public class Emoji implements Serializable {

    private String mouthPath;
    private String facePath;
    private String eyesbrowsPath;
    private String eyesPath;
    private String accessoriesPath;
    private String currentEmojiPath;

    public Emoji(String mouthPath, String facePath, String eyesbrowsPath, String eyesPath, String accessoriesPath) {
        this.mouthPath = mouthPath;
        this.facePath = facePath;
        this.eyesbrowsPath = eyesbrowsPath;
        this.eyesPath = eyesPath;
        this.accessoriesPath = accessoriesPath;
    }

    
    public Emoji(Image eyes, Image mouth, Image face, Image eyesbrows, Image accessories) {
        this.eyesPath = buildWithoutNull(eyes);
        this.mouthPath = buildWithoutNull(mouth);
        this.facePath = buildWithoutNull(face);
        this.accessoriesPath = buildWithoutNull(accessories);
        this.eyesbrowsPath = buildWithoutNull(eyesbrows);
    }
    public static Image toImage(String path) {
        if(path.equals("")) return null;
        return new Image(path);
    }

    private static String buildWithoutNull(Image img){
        if(img!=null) return img.getUrl();
        return "";
    }
    public String getMouthPath() {
        return mouthPath;
    }

    public void setMouthPath(String mouthPath) {
        this.mouthPath = mouthPath;
    }

    public String getFacePath() {
        return facePath;
    }

    public void setFacePath(String facePath) {
        this.facePath = facePath;
    }

    public String getEyesbrowsPath() {
        return eyesbrowsPath;
    }

    public void setEyesbrowsPath(String eyesbrowsPath) {
        this.eyesbrowsPath = eyesbrowsPath;
    }

    public String getEyesPath() {
        return eyesPath;
    }

    public void setEyesPath(String eyesPath) {
        this.eyesPath = eyesPath;
    }

    public String getAccessoriesPath() {
        return accessoriesPath;
    }

    public void setAccessoriesPath(String accessoriesPath) {
        this.accessoriesPath = accessoriesPath;
    }

    public String getCurrentEmojiPath() {
        return currentEmojiPath;
    }

    public void setCurrentEmojiPath(String currentEmojiPath) {
        this.currentEmojiPath = currentEmojiPath;
    }

    public boolean haveFace() {
        return this.facePath != null;
    }

    public boolean haveEyes() {
        return this.eyesPath != null;
    }

    public boolean haveMouth() {
        return this.mouthPath != null;
    }

    public boolean haveEyeBrows() {
        return this.eyesbrowsPath != null;
    }

    public boolean haveAccessories() {
        return this.accessoriesPath != null;
    }

}
