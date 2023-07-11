/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import TDAs.DoubleCircularList;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author kev-roldan
 */
public class Resource {

    public enum CurrentType {
        FACES, EYES, EYEBROWS, ACCESSORIES, MOUTH
    };

    private DoubleCircularList<Image> resourcesList;
    CurrentType type;

    public CurrentType getType() {
        return type;
    }

    public void setType(CurrentType type) {
        this.type = type;
    }

    public Resource(String type) {
        this.resourcesList = loadResources(type);
        this.type = CurrentType.valueOf(type.toUpperCase());

    }

    private DoubleCircularList<Image> loadResources(String typeList) {
        //carga listas de imagenes a travez de archivos
        DoubleCircularList<Image> resourceList = new DoubleCircularList<>();
        String path = "src/main/resources/images/" + typeList.toLowerCase();
        Path files = Paths.get(path);
        int elementsSize;
        try {
            elementsSize = (int) Files.list(files).count();
            System.out.println("Cantidad de elementos en la carpeta " + typeList.toLowerCase() + ": " + elementsSize);
        } catch (IOException e) {
            elementsSize = 0;
            System.out.println("Error al acceder a la carpeta: " + e.getMessage());
        }

        for (int i = 0; i < elementsSize; i++) {
            String rout = "/images/" + typeList.toLowerCase() + "/" + typeList.toLowerCase() + "_" + (i + 1) + ".png";
            Image img = new Image(getClass().getResource(rout).toExternalForm());
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

    public static boolean createResourceDirectory(String resourcePath) {

        try {
            String directoryPath = "src/main/resources/Profiles/" + resourcePath;
            Path path = Paths.get(directoryPath);
            Files.createDirectory(path);

            String targetDirectoryPath = "target/classes/Profiles/" + resourcePath;
            Path targetPath = Paths.get(targetDirectoryPath);
            Files.createDirectory(targetPath);

            return true;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }

    }

    public static void deleteFilePath(String resourcePath) {
//        try {
//            URL resourceUrl = Resource.class.getResource(resourcePath);
//            if (resourceUrl != null) {
//                try (InputStream inputStream = resourceUrl.openStream()) {
//                    Files.deleteIfExists(Paths.get(resourceUrl.toURI()));
//                } catch (URISyntaxException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            System.out.println("Archivo borrado exitosamente.");
//        } catch (IOException e) {
//            System.out.println("Error al borrar el archivo: " + e.getMessage());
//        }
        try {
            // Convierte la ruta en un objeto Path
            Path path = Paths.get(resourcePath);

            // Borra el archivo utilizando el método delete de Files
            Files.delete(path);

            System.out.println("Archivo borrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al borrar el archivo: " + resourcePath);
        }
    }

}
