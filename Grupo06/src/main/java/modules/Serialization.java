/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import TDAs.ArrayList;
import TDAs.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jorge Daniel
 */
public class Serialization {
    
    public static void serialize(ArrayList<Register> array, String name) {
        try {
            FileOutputStream fout = new FileOutputStream("src/main/java/serialized/"+name+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(array);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static ArrayList<Object> unserialize(String name) {
        try {
            FileInputStream file = new FileInputStream("src/main/java/serializados/"+name+".ser");
            ObjectInputStream in = new ObjectInputStream(file);
            ArrayList<Object> array = (ArrayList<Object>) in.readObject();

            in.close();
            file.close();
            return array;
        } catch (Exception e) {
            return null;
        }
    }
    
}
