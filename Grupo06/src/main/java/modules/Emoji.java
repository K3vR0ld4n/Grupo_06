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

//    private String mouthPath;
//    private String facePath;
//    private String eyesbrowsPath;
//    private String eyesPath;
//    private String accessoriesPath;
//    private String currentEmojiPath;
    private Component mouthComponent;
    private Component faceComponent;
    private Component eyesbrowsComponent;
    private Component eyeComponent;
    private Component accessoriesComponent;
    private Component currentEmojiPath;

//    public Emoji(String mouthPath, String facePath, String eyesbrowsPath, String eyesPath, String accessoriesPath) {
//        this.mouthPath = mouthPath;
//        this.facePath = facePath;
//        this.eyesbrowsPath = eyesbrowsPath;
//        this.eyesPath = eyesPath;
//        this.accessoriesPath = accessoriesPath;
//    }
    public Emoji(Component mouthPath, Component facePath, Component eyesbrowsPath, Component eyesPath, Component accessoriesPath, Component currentEmojiPath) {
        this.mouthComponent = mouthPath;
        this.faceComponent = facePath;
        this.eyesbrowsComponent = eyesbrowsPath;
        this.eyeComponent = eyesPath;
        this.accessoriesComponent = accessoriesPath;
        this.currentEmojiPath = currentEmojiPath;
    }

    public Emoji(ImageView eyes, ImageView mouth, ImageView face, ImageView eyesbrows, ImageView accessories) {
        this.eyeComponent = buildWithoutNull(eyes);
        this.mouthComponent = buildWithoutNull(mouth);
        this.faceComponent = buildWithoutNull(face);
        this.accessoriesComponent = buildWithoutNull(accessories);
        this.eyesbrowsComponent = buildWithoutNull(eyesbrows);
    }

    public static Image toImage(String path) {
        if (path.equals("")) {
            return null;
        }
        return new Image(path);
    }

    private static Component buildWithoutNull(ImageView img) {
        if (img != null && img.getImage() != null) {
            Component c = new Component(img.getImage().getUrl(), img.getX(), img.getY(), img.getFitWidth(), img.getFitHeight());
            return c;
        }
        return new Component("", 0, 0, 0, 0);
    }

    public String getMouthPath() {
        return mouthComponent.getPath();
    }

    public String getFacePath() {
        return faceComponent.getPath();
    }

    public String getEyesbrowsPath() {
        return eyesbrowsComponent.getPath();
    }

    public String getEyesPath() {
        return eyeComponent.getPath();
    }

    public String getAccessoriesPath() {
        return accessoriesComponent.getPath();
    }

    public String getCurrentEmojiPath() {
        return currentEmojiPath.getPath();
    }

    public boolean haveFace() {
        return this.faceComponent != null;
    }

    public boolean haveEyes() {
        return this.eyeComponent != null;
    }

    public boolean haveMouth() {
        return this.mouthComponent != null;
    }

    public boolean haveEyeBrows() {
        return this.eyesbrowsComponent != null;
    }

    public boolean haveAccessories() {
        return this.accessoriesComponent != null;
    }

    public Component getEyeComponent() {
        return this.eyeComponent;
    }

    public Component getFaceComponent() {
        return this.faceComponent;
    }

    public Component getAccessoriesComponent() {
        return this.accessoriesComponent;
    }

    public Component getMouthComponent() {
        return this.mouthComponent;
    }

    public Component getEyesbrowsComponent() {
        return this.eyesbrowsComponent;
    }
}
