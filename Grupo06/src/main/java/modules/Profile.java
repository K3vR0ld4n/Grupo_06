/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;
import TDAs.List;
import java.io.IOException;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javafx.scene.image.Image;
import utils.Resource;
import utils.Serialization;

/**
 *
 * @author Jorge Daniel
 */
public class Profile implements Serializable {

    private String name;
    private String password;
    private String mail;
    private Library library;
    public static ArrayList<Profile> arrayProfile;

    public Profile(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.library = new Library();
        arrayProfile.addLast(this);
        Resource.createResourceDirectory(mail);

    }

    public void saveUserComponent(String imagePath, String type) {

        String profilePath = "src/main/resources/Profiles/" + this.mail + "/" + type + this.library.getUserComponents().size() + imagePath.substring(imagePath.length() - 4);
        
        String newImagePath = profilePath.substring(18);
        System.out.println(newImagePath);
        try {
            Path sourcePath = Path.of(imagePath);
            Path destinationPath = Path.of(profilePath);
            //copy image
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            
            Image img = new Image(getClass().getResource(newImagePath).toExternalForm());
            
            
           // Image img = new Image(getClass().getResource(profilePath.substring(18)).toExternalForm());
           
            
            this.library.getUserComponents().addLast(img);
            // Rename image
            //    Files.move(destinationPath, destinationPath.resolveSibling(type+this.library.getUserComponents().size()+imagePath.substring(imagePath.length()-4)));

            // System.out.println("Imagen copiada y renombrada exitosamente.");
        } catch (Exception e) {
            System.out.println(getClass().getResource(newImagePath));
            e.printStackTrace();
        }

    }

    public List<Image> loadUserComponents(String type) {
        ArrayList<Image> toLoad = new ArrayList<>();
        ArrayList<Image> userComponents = this.library.getUserComponents();
        if (!userComponents.isEmpty()) {
            for (int i = 0; i < userComponents.size(); i++) {
                if(userComponents.get(i).getUrl().contains(type)) toLoad.addLast(userComponents.get(i));
            }

        }

        return toLoad;

    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "\nProfile{" + "name=" + name + ", password=" + password + ", mail=" + mail + "}\n";

    }

    public static void loadProfiles() {
        if (Serialization.unserialize("profile") == null) {
            arrayProfile = new ArrayList<>();
        } else {
            arrayProfile = Serialization.unserialize("profile");
        }

    }

    //Si ....... no
}
