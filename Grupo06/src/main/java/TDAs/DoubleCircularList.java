package TDAs;

import java.io.Serializable;
import java.util.Iterator;

public class DoubleCircularList<E> implements List<E>, Serializable {

    private Node<E> last;

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(e);
        if (isEmpty()) {
            last = nuevo;
            last.setNext(last);
            last.setPrev(last);
        } else {
            nuevo.setNext(last.getNext());
            nuevo.setPrev(last);
            nuevo.getNext().setPrev(nuevo);
            last.setNext(nuevo);
        }
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(e);
        if (isEmpty()) {
            last = nuevo;
            last.setNext(last);
            last.setPrev(last);
        } else {
            nuevo.setNext(last.getNext());
            nuevo.setPrev(last);
            last.setNext(nuevo);
            nuevo.getNext().setPrev(nuevo);
            last = nuevo;
        }
        return true;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int cont = 1;
        Node<E> viajero = last.getNext();
        while (viajero != last) {
            cont++;
            viajero = viajero.getNext();
        }
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public void add(int index, E element) {
        Node<E> nuevo = new Node<>(element);
        if (element == null) {
            System.out.println("Ingrese un elemento válido");
        }
        if (isEmpty()) {
            last = nuevo;
            last.setNext(nuevo);
            last.setPrev(nuevo);
        } else {
            Node<E> nodoAnterior = last.getPrev();
            nuevo.setNext(last);
            nuevo.setPrev(nodoAnterior);
            last.setPrev(nuevo);
            nodoAnterior.setNext(nuevo);
        }
    }

    @Override
    public boolean remove(E element) {
        if (isEmpty() || element == null) {
            return false; //Lista vacia o el elemento es nulo
        }
        Node<E> nodo = last;
        boolean retorno = false;
        do {
            if (nodo.getContent().equals(element)) {
                Node<E> prevNode = nodo.getPrev();
                Node<E> nextNode = nodo.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                if (nodo == last) {
                    last = nextNode;
                }
                retorno = true;
                break;
            }
            nodo = nodo.getNext();
        } while (nodo != last);
        return retorno;
    }

    @Override
    public E get(int index) {
        E element = null;
        if (isInRange(index)) {
            Node<E> traveler = this.last.getNext();
            int cont = 0;
            while (cont <= index) {
                element = traveler.getContent();
                traveler = traveler.getNext();
                cont++;
            }
        }
        return element;
    }

    public E getNext(E element) {
        Node<E> currentNode = last.getNext();
        do {
            if (currentNode.getContent().equals(element)) {
                return currentNode.getNext().getContent();
            }
            currentNode = currentNode.getNext();
        } while (currentNode != last.getNext());
        return null;
    }

    public E getPrevious(E element) {
        Node<E> currentNode = last.getNext();
        do {
            if (currentNode.getContent().equals(element)) {
                return currentNode.getPrev().getContent();
            }
            currentNode = currentNode.getNext();
        } while (currentNode != last.getNext());
        return null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]"; // lista vacia
        }
        String retorno = "[";
        Node<E> viajero = last.getNext();
        boolean condicion = false;
        while (!condicion) {
            retorno += (viajero.getContent());
            viajero = viajero.getNext();
            if (viajero != last) {
                retorno += ", ";
            } else {
                if (this.size() == 1) {
                    retorno += "]";
                } else {
                    retorno += (", " + viajero.getContent() + "]");
                }
                condicion = true;
            }
        }
        return retorno;
    }

    private boolean isInRange(int index) {
        return index >= 0 && index < this.size();

    }

    @Override
    public boolean addAll(List<E> elements) {
        if (!elements.isEmpty()) {
            for (E element : elements) {
                this.addLast(element);
            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean union(List<E> elements) {

        if (!elements.isEmpty()) {
            for (E elemento : elements) {
                if (!this.contains(elemento)) {
                    this.addLast(elemento);
                }
            }

            return true;
        }

        return false;

    }

    @Override
    public boolean contains(E element) {
        if (element != null) {
            Node<E> traveler = this.last.getNext();

            while (traveler != this.last) {
                E content = traveler.getContent();
                traveler = traveler.getNext();
                if (content.equals(element)) {
                    return true;
                }

            }
        }
        return false;
    }

}
