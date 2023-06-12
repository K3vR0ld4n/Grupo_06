package TDAs;


public class DoubleCircularList<E> implements List<E> {

    private Node<E> last;

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(e);
        if (isEmpty()) {
            last = nuevo;
            last.setNext(nuevo);
            last.setPrev(nuevo);
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
            last.setNext(nuevo);
            last.setPrev(nuevo);
        } else {
            nuevo.setNext(last);
            nuevo.setPrev(last.getPrev());
            nuevo.getPrev().setNext(nuevo);
            last.setPrev(nuevo);
            last = nuevo;
        }
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
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(E element) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                retorno += (", "+viajero.getContent()+"]");
                condicion = true;
            }
        }
        return retorno;
    }

}
