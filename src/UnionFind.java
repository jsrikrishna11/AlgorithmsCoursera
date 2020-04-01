public class UnionFind {
    private static int[] id;
    private static int length;
    static void display(){
        for(int i = 0; i<length;i++){
            System.out.println(id[i]);
        }
    }
    static void init(int length){
        id = new int[length];
        for(int i = 0; i<length;i++){
            id[i] = i;
        }
    }
    static int root(int a){
        int i = a;
        int parent = id[i];
        while(parent!=i){
            i = parent;
            parent = id[i];
        }
        return parent;
    }
    static void union( int a, int b){
        id[b] = root(a);
    }
   static boolean connected(int a , int b){
        return root(a) == root(b);
    }

    public static void main(String[] args) {
        length = 10;
        init(length);
        union(4,3);
        union(3,8);
        union(6,5);
        union(9,4);
        union(2,1);
        union(5,0);
        union(7,2);
        union(6,1);
        union(7,3);
        System.out.println("Are these connected?"+connected(5,4));
    }
}

