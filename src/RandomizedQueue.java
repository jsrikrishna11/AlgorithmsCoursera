import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;

        Node(T d) {
            this.data = d;
            this.next = null;
        }

        public Node goTo(int n) {
            int i = 0;
            Node ptr = first;
            while (++i < n - 1) {
                ptr = ptr.next;
            }
            return ptr;
        }
    }

    Node first, last;
    int size;

    RandomizedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new litr();
    }

    private class litr implements Iterator<T> {
        private Node current;

        litr() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {
            Random rand = new Random();
            int eliminate = rand.nextInt(size);
            System.out.println("Does it have next? " + hasNext());
            current = first.goTo(eliminate);
            if (hasNext()) {
                return current.data;
            }
            throw new NoSuchElementException();
        }

    }


    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        Node add = new Node(item);
        if (last == null && first == null) {
            last = add;
            first = add;
        } else {
            last.next = add;
            last = last.next;
        }
        size++;
    }

    public T deque() {
        //remove random item!
        T temp;
        if (first == null) throw new NoSuchElementException();
        Random rand = new Random();
        int eliminate = rand.nextInt(size);
        if (eliminate == 0) {
            Node del = first;
            first = first.next;
            del.next = null;
            temp = del.data;
            del = null;
            size--;
            return temp;
        } else {
            Node delPar = first.goTo(eliminate);
            Node del = delPar.next;
            delPar.next = del.next;
            del.next = null;
            size--;
            temp = del.data;
            del = null;
        }
        if (size == 0) {
            first = null;
            last = null;
        }
        return temp;
    }

    public T sample() {
        //return a random item
        Random rand = new Random();
        int sample = rand.nextInt(size);
        Node selection = first.goTo(sample).next;
        return selection.data;
    }


}
