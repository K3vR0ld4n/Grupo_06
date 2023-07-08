/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;
import java.io.Serializable;
import javafx.scene.image.Image;


/**
 *
 * @author kev-roldan
 */
public class Emoji implements Serializable{
    private Image eyes;
    private Image mouth;
    private Image face;
    private Image eyesbrows;
    private Image accessories;

    public Emoji(Image eyes, Image mouth, Image face, Image eyesbrows, Image accessories) {
        this.eyes = eyes;
        this.mouth = mouth;
        this.face = face;
        this.accessories = accessories;
        this.eyesbrows = eyesbrows;
    }
    
    public boolean haveFace(){
        return this.face != null;
    }
    
    public boolean haveEyes(){
        return this.eyes != null;
    }
    
    public boolean haveMouth(){
        return this.mouth != null;
    }
    
    public boolean haveEyeBrows(){
        return this.eyesbrows != null;
    }
    
    public boolean haveAccessories(){
        return this.accessories != null;
    }
    
    public Image getEyes() {
        return eyes;
    }

    public void setEyes(Image eyes) {
        this.eyes = eyes;
    }

    public Image getMouth() {
        return mouth;
    }

    public void setMouth(Image mouth) {
        this.mouth = mouth;
    }

    public Image getFace() {
        return face;
    }

    public void setFace(Image face) {
        this.face = face;
    }

    public Image getEyesbrows() {
        return eyesbrows;
    }

    public void setEyesbrows(Image eyesbrows) {
        this.eyesbrows = eyesbrows;
    }

    public Image getAccessories() {
        return accessories;
    }

    public void setAccessories(Image accessories) {
        this.accessories = accessories;
    }
    
    
}
