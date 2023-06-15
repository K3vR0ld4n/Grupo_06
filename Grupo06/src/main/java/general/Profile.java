/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
import TDAs.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author kev-roldan
 */
public class Profile {
    public static ArrayList<Profile> profileList=loadProfiles();

    private String user;
    private String password;
    private String email;
    private Image avatar;
    private Library library;

    public Profile(String user, String password, String email) {
        this.user = user;
        this.password = password;
        this.email = email;
    }

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    
        
    
    private static ArrayList<Profile> loadProfiles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
