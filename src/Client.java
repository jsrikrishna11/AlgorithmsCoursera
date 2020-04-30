public class Client {
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 1; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int a : queue) {
            for (int b : queue) {
                System.out.print(" ( " + a + " - " + b + " ) ");
            }
            System.out.println("");
        }
    }
}
