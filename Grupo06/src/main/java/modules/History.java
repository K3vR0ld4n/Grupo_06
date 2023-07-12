package modules;

import TDAs.ArrayList;
import TDAs.List;
import java.util.Stack;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lancervs
 */
public class History {
    
    private Stack<Emoji> historyBack;
    private Stack<Emoji> historyForward;
    private Emoji actual;
    
    public History(Emoji a){
        historyBack = new Stack<>();
        historyForward= new Stack<>();
        this.actual = a;
    }
    
    public Emoji back(){
        System.out.println(this.historyBack);
        if(!historyBack.isEmpty()){
            historyForward.push(this.actual);
            System.out.println("patras");
            System.out.println(actual.getFaceComponent());
            actual = historyBack.pop();
            return actual;
       }
       return null;
       
    }
    
    public Emoji advance(){
       System.out.println(this.historyForward);
       if(!historyForward.isEmpty()){
            historyBack.push(actual);
            System.out.println("palante");
            actual = historyForward.pop();
            return actual;
       }
       return null;
    }
    
    public void setActual(Emoji newE){
        Emoji old = this.actual;
        this.historyBack.push(old);
        this.actual = newE;
    }

    public Emoji getActual() {
        return actual;
    }
    
    public void clear(){
        while(!this.historyBack.isEmpty()){
            this.historyBack.pop();
        }
        while(!this.historyForward.isEmpty()){
            this.historyForward.pop();
        }
    }
   
}
