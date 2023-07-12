package TDAs;

public interface List<E> extends Iterable<E> {

    public boolean addFirst(E e); // inserta el elemento e al inicio

    public boolean addLast(E e); // inserta el elemento e al final

    public int size();

    public boolean isEmpty();

    public void clear();          

    public void add(int index, E element); // inserta element en la posición index

    public boolean remove(E element); // remueve y retorna el elemento en la posición index

    public E get(int index); // retorna el elemento ubicado en la posición index
    
    public String toString(); // retorna una cadena de caracteres representando los elementos que la lista contiene*/
    
    public boolean addAll(List<E> elements);
    
    public boolean contains(E element);

}