/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import TDAs.ArrayList;
import TDAs.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modules.Profile;

/**
 *
 * @author Jorge Daniel
 */
public class Serialization<E> {
    
    public static <E> void serialize(List<E> array, String name) {
        try {
            FileOutputStream fout = new FileOutputStream("userData/serialized/"+name+".ser");
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
    
    public static <E>List<E> unserialize(String name) {
        try {
            FileInputStream file = new FileInputStream("userData/serialized/"+name+".ser");
            ObjectInputStream in = new ObjectInputStream(file);
            List<E> array = (List<E>) in.readObject();

            in.close();
            file.close();
            return array;
        } catch (Exception e) {
            return null;
        }
    }
    
}
