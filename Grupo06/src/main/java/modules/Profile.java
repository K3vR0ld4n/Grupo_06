/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;

import java.io.Serializable;
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
        if(Serialization.unserialize("profile")==null) arrayProfile=new ArrayList<>();
        else arrayProfile=Serialization.unserialize("profile");
       
    }

    //Si
}
