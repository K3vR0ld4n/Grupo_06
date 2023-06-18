/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;
import java.io.Serializable;

/**
 *
 * @author kev-roldan
 */
public class Library implements Serializable{
    public static ArrayList<Emoji> defaultEmoji=loadDefaults();
    private ArrayList<Emoji> userEmoji;

    public Library() {
        this.userEmoji = new ArrayList<>();
    }

    public ArrayList<Emoji> getUserEmoji() {
        return userEmoji;
    }

    public boolean addEmoji(Emoji emoji){
        return false;
    }
    
    private static ArrayList<Emoji> loadDefaults(){
        ArrayList<Emoji> newArray = new ArrayList<>();
        return newArray;
    }
    
    
    
} 
