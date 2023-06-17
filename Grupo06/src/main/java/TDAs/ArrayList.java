/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;

import java.util.Iterator;

/**
 *
 * @author kev-roldan
 */
public class ArrayList<E> implements List<E>, Iterable<E> {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayList() {
        // elements = new E[100]; // NO vale
        elements = (E[]) new Object[MAX_SIZE];
        effectiveSize = 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            //throw new NullPointerException("Null elements are not accepted");
            return false;
        } else if (isEmpty()) {
            elements[effectiveSize++] = element;
            return true;
        }
        if (isFull()) {
            addCapacity();
        }
        // empujar para hacer espacio. Bit shifting
        for (int i = effectiveSize; i > 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        if(this.isEmpty()){
            addFirst(element);
            return true;
        }
        elements[effectiveSize++] = element;
        return true;
        

    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > effectiveSize) {
            System.out.println("Indice incorrecto");
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        effectiveSize++;
    }
//remueve el elemento en la posicion index y lo retorna

    public E remove(int index) {
        if (isInRange(index)) {
            E elemnt = elements[index];
            for (int i = (index + 1); i < effectiveSize; i++) {
                elements[i - 1] = elements[i];
            }
            effectiveSize--;
            return elemnt;

        }
        return null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        // copiando los elementos del arreglo viejo al nuevo
//        for (int i= 0; i<effectiveSize; i++) {
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;

    }

    @Override
    public String toString() {
        String chain = "";
        if (!isEmpty()) {
            for (int i = 0; i < effectiveSize; i++) {
                if (i == (effectiveSize - 1)) {
                    chain += elements[i];
                } else {
                    chain += elements[i] + ",";
                }
            }
        }
        return chain;
    }

    //Metodo creado para tener mayoe facilidad a la hora de validar un indice
    private boolean isInRange(int Idx) {
        return Idx >= 0 && Idx < effectiveSize;
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private int index;
            
            @Override
            public boolean hasNext(){
                return index < elements.length;
            }
            
            @Override
            public E next(){
                E element = elements[index];
                index++;
                return element;
            }
        };
    }


}
