/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author kev-roldan
 */
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author kev-roldan
 */
public class ArrayList<E> implements List<E>, Serializable {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayList() {
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
        for (int i = 0; i < effectiveSize; i++) {
            elements[i] = null;

        }
        effectiveSize = 0;

    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
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
            elements[i] = elements[i - 1];
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
        if (this.isEmpty()) {
            addFirst(element);
            return true;
        }
        elements[effectiveSize++] = element;
        return true;

    }

    @Override
    public void add(int index, E element) {
        if (!isInRange(index) || element == null) {
            System.out.println("Insercion Incorrecta");
        } else {
            if (isFull()) {
                addCapacity();
            }
            if (isEmpty()) {
                elements[0] = element;
                effectiveSize++;
            } else {
                for (int i = effectiveSize; i > index; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[index] = element;
                effectiveSize++;
            }

        }

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
        if (!isInRange(index)) {
            return null;
        }
        return elements[index];
    }

    private void addCapacity() {
        MAX_SIZE *= 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];

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
        if (isEmpty()) {
            return Idx == 0;
        }
        return Idx >= 0 && Idx < effectiveSize;
    }

    @Override
    public boolean remove(E element) {
        if (element != null && contains(element)) {
            int index = 0;
            for (int i = 0; i < effectiveSize; i++) {
                E e = elements[i];
                if (e.equals(element)) {
                    index = i;
                    i = effectiveSize;
                }
            }
            remove(index);
            return true;
        }
        return false;

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < effectiveSize;
            }

            @Override
            public E next() {
                E element = elements[index];
                index++;
                return element;
            }
        };
    }

    @Override
    public boolean addAll(List<E> elementsInput) {
        if (elementsInput.isEmpty()) {
            System.out.println("No se puede ingresar una lista vacia");
            return false;
        } else {
            if (isFull()) {
                addCapacity();
            }
            for (int i = 0; i < elementsInput.size(); i++) {

                this.elements[effectiveSize++] = elementsInput.get(i);
                System.out.println("Elemento " + elementsInput.get(i) + " ingresado");
            }
            return true;
        }
    }

    @Override
    public boolean contains(E element) {

        if (element != null) {
            for (int i = 0; i < effectiveSize; i++) {
                if (elements[i].equals(element)) {
                    return true;
                }
            }
        }
        return false;

    }

}

