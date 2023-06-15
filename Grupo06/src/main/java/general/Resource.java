/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import TDAs.DoubleCircularList;
import javafx.scene.image.Image;

/**
 *
 * @author kev-roldan
 */
public class Resource {
    
    private DoubleCircularList<Image> faceList;
    private DoubleCircularList<Image> eyesList;
    private DoubleCircularList<Image> mouthList;
    private DoubleCircularList<Image> eyesBrowsList;
    private DoubleCircularList<Image> accessoryList;
    private DoubleCircularList<Image> userList;

    public Resource() {
        this.faceList = loadResources("face");
        this.eyesList = loadResources("eyes");
        this.mouthList = loadResources("mouth");
        this.eyesBrowsList = loadResources("eyesBrows");
        this.accessoryList = loadResources("accessory");
        this.userList = new DoubleCircularList<>();
    }

    public DoubleCircularList<Image> getFaceList() {
        return faceList;
    }

    public void setFaceList(DoubleCircularList<Image> faceList) {
        this.faceList = faceList;
    }

    public DoubleCircularList<Image> getEyesList() {
        return eyesList;
    }

    public void setEyesList(DoubleCircularList<Image> eyesList) {
        this.eyesList = eyesList;
    }

    public DoubleCircularList<Image> getMouthList() {
        return mouthList;
    }

    public void setMouthList(DoubleCircularList<Image> mouthList) {
        this.mouthList = mouthList;
    }

    public DoubleCircularList<Image> getEyesBrowsList() {
        return eyesBrowsList;
    }

    public void setEyesBrowsList(DoubleCircularList<Image> eyesBrowsList) {
        this.eyesBrowsList = eyesBrowsList;
    }

    public DoubleCircularList<Image> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(DoubleCircularList<Image> accessoryList) {
        this.accessoryList = accessoryList;
    }

    public DoubleCircularList<Image> getUserList() {
        return userList;
    }

    public void setUserList(DoubleCircularList<Image> userList) {
        this.userList = userList;
    }

    private DoubleCircularList<Image> loadResources(String face) {
        //carga listas de imagenes a travez de archivos
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}
