/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;

/**
 *
 * @author Jorge Daniel
 */
public class Login {
    private String name;
    private String password;
    public static ArrayList<Login> loginArray = new ArrayList<>();

    public Login(String name, String password) {
        this.name = name;
        this.password = password;
        
        loginArray.addLast(this);
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
    
    
}
