/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
import javafx.scene.image.Image;


/**
 *
 * @author kev-roldan
 */
public class Emoji {
    private Image eyes;
    private Image mouth;
    private Image face;
    private Image eyesbrows;
    private Image accessories;

    public Emoji(Image eyes, Image mouth, Image face) {
        this.eyes = eyes;
        this.mouth = mouth;
        this.face = face;
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
