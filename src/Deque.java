import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<T> implements Iterable<T> {
    private int size;
    private class Node {
        T data;
        Node next, prev;
        Node(final T d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }
    Node first, last;
    public Deque(){
        first = null;
        last = null;
        size = 0;
    }
    
    public Iterator<T> iterator(){ return new litr();}

    private class litr implements Iterator<T>{
        private Node  current;
        
        litr(){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!this.hasNext()) throw new NoSuchElementException();
            final T temp = current.data;
            current = current.next;
            return temp;
        }  
    }

    public boolean isEmpty(){
        return first == last;
    }

    public int size(){
        return size;
    }

    public void addFirst(final T item){
        if(item == null) throw new IllegalArgumentException();
        size++;
        final Node n = new Node(item);
        if(size == 1){
            first = n;
            last = n;
        }
        else{
            first.prev = n;
            n.next = first;
            first = n;
        }
    }

    public void addLast(final T item){
        if(item == null) throw new IllegalArgumentException();
        size++;
        final Node n = new Node(item);
        if(size == 1){
            first = n;
            last = n;
        }else{
            last.next = n;
            n.prev = last;
            last = n;
        }

    }

    public T removeFirst(){
        if(!this.isEmpty()){
            this.size--;
            final Node temp = first;
            first = first.next;
            temp.next = null;
            first.prev = null;
            return temp.data;
        }
        throw new NoSuchElementException();
    }

    public T removeLast(){
        if(!this.isEmpty()){
            this.size--;
            final Node temp = last;
            last = last.prev;
            temp.prev = null;
            last.next = null;
            return temp.data;
        }
        throw new NoSuchElementException();
    }
}
