import java.util.*;

public class RandomizedQueue<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node(T d){
            this.data = d;
            this.next = null;
        }
        public Node goTo(int n){
            int i =0;
            Node ptr = this;
            while( i < n-1 ){
                ptr = ptr.next;
                i++;
            }
            return ptr;
        }
    }
    
    Node first, last;
    int size;

    RandomizedQueue(){
        first = null;
        last = null;
        size = 0;
    }
    @Override
    public Iterator<T> iterator() {
        return new litr();
    }
    private class litr implements Iterator<T>{
        private Node current; 
        int iterations;
        litr(){
            current = first;
            iterations = 0;
        }

        @Override
        public boolean hasNext() {
            return iterations < size;
        }

        @Override
        public T next() {
            Random rand = new Random();
            int eliminate = rand.nextInt(size);
            current = first.goTo(eliminate);
            if(hasNext()){
                iterations++;
                return current.data;
            }
            throw new NoSuchElementException();
        }
        
    }

    
    public boolean isEmpty(){
        return first == last;
    }
    public int size(){
        return size;
    }
    public void enqueue(T item){
        Node add =  new Node(item);
        if(last == null && first == null){
            last = add;
            first = add;
        }
        else{
        last.next = add;
        last = last.next;
        }
        size++;
    }

    public T Deque(){
        //remove random item!
        if( first == last ) throw new NoSuchElementException();
        Random rand = new Random();
        int eliminate = rand.nextInt(size);
        Node delPar = first.goTo(eliminate);
        Node del = delPar.next;
        delPar.next = del.next;
        delPar.next = null;
        size--;
        return del.data;
    }
    public T sample(){
        //return a random item 
        Random rand = new Random();
        int eliminate = rand.nextInt(size);
        Node selection = first.goTo(eliminate).next;
        return selection.data;
    }

    
}