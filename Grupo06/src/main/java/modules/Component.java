/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.positionX) ^ (Double.doubleToLongBits(this.positionX) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.positionY) ^ (Double.doubleToLongBits(this.positionY) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.imagePath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Component other = (Component) obj;
        if (Double.doubleToLongBits(this.positionX) != Double.doubleToLongBits(other.positionX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.positionY) != Double.doubleToLongBits(other.positionY)) {
            return false;
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        return Objects.equals(this.imagePath, other.imagePath);
    }
    
    
    
}
