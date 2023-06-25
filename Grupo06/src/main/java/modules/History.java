package modules;

import java.util.Stack;
import javafx.scene.image.Image;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lancervs
 */
public class History {
    
    public static Stack<Emoji> historyBack = new Stack<>();
    public static Stack<Emoji> historyForward = new Stack<>();
    
    
    public static Emoji back(Emoji actualEmoji){
        
        if(!historyBack.isEmpty()){
            historyForward.push(actualEmoji);
            System.out.println("patras");
            return historyBack.pop();
       }
       return null;
       
    }
    
    public static Emoji advance(Emoji actualEmoji){
       
       if(!historyForward.isEmpty()){
            historyBack.push(actualEmoji);
            System.out.println("palante");
            return historyForward.pop();
       }
       return null;
    }
}
