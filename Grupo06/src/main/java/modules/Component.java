/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.Serializable;

/**
 *
 * @author lancervs
 */

public class Component implements Serializable {

    private double positionX;
    private double positionY;

    private double width;
    private double height;
    private String imagePath;

    public Component(String imgP, double positionX, double positionY, double width, double height) {
        this.imagePath = imgP;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPath() {
        return this.imagePath;
    }

    public void setPath(String p) {
        this.imagePath = p;
    }

    @Override
    public String toString() {
        return "Component{" + "positionX=" + positionX + ", positionY=" + positionY + ", width=" + width + ", height=" + height + ", imagePath=" + imagePath + '}';
    }
}
