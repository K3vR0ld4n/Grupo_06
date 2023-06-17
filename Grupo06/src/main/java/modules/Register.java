/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;
import TDAs.List;
import java.io.Serializable;

/**
 *
 * @author Jorge Daniel
 */
public class Register implements Serializable{
    private String name;
    private String password;
    private String mail;
    public static ArrayList<Register> RegisterArray = new ArrayList<>();

    public Register(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        RegisterArray.addLast(this);
        
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

    public ArrayList<Register> getRegisterArray() {
        return RegisterArray;
    }

    public void setRegisterArray(ArrayList<Register> RegisterArray) {
        this.RegisterArray = RegisterArray;
    }

    @Override
    public String toString() {
        return "\nRegister{" + "name=" + name + ", password=" + password + ", mail=" + mail + "}\n";

    }
    
    //Si
}
