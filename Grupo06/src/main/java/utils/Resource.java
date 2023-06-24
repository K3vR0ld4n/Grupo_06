/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import TDAs.DoubleCircularList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.image.Image;

/**
 *
 * @author kev-roldan
 */
public class Resource {
    
    private DoubleCircularList<Image> resourcesList;


    public Resource(String type) {
        this.resourcesList = loadResources(type);
       
    }


    private  DoubleCircularList<Image> loadResources(String typeList) {
        //carga listas de imagenes a travez de archivos
        DoubleCircularList<Image> resourceList= new DoubleCircularList<>();
        String path = "src/main/resources/images/"+typeList.toLowerCase();
        Path files = Paths.get(path);
        int elementsSize;
        try {
            elementsSize = (int)Files.list(files).count();
            System.out.println("Cantidad de elementos en la carpeta "+typeList.toLowerCase()+": " + elementsSize);
        } catch (IOException e) {
            elementsSize=0;
            System.out.println("Error al acceder a la carpeta: " + e.getMessage());
        }

        
        for (int i = 0; i < elementsSize; i++) {
            String rout="/images/"+typeList.toLowerCase()+"/"+typeList.toLowerCase()+"_"+(i+1)+".png";
            Image img= new Image(getClass().getResource(rout).toExternalForm());
            resourceList.addLast(img);
        }
    
        return resourceList;
        }

    public DoubleCircularList<Image> getResourcesList() {
        return resourcesList;
    }

    public void setResourcesList(DoubleCircularList<Image> resourcesList) {
        this.resourcesList = resourcesList;
    }

    @Override
    public String toString() {
        return "Resource{" + "resourcesList=" + resourcesList + '}';
    }
    
    
  
}
