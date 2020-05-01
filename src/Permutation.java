import java.io.IOException;

public class Permutation {
    public static void main(String[] args) throws IOException {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        int len = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        System.out.println(q.size());
        for (int i = 0; i < len; i++) {
            System.out.println(q.deque());
        }
    }
}
