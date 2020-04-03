public class UnionFind {
    private static int[] id;
    private static int length;
    private static int[] size;
    static void init(int length){
        id = new int[length];
        size = new int[length];
        for(int i = 0; i<length;i++){
            id[i] = i;
            size[i]=1;
        }
    }
    static void display(int [] d){
        for(int i = 0; i<length;i++){
            System.out.println(d[i]);
        }
    }
    static int root(int a){
        int i = a;
        int parent = id[i];
        int sz = 0;
        while(parent!=i){
            sz += 1;
            i = parent;
            parent = id[i];
        }
        size[parent]=sz;
        return parent;
    }
    static void qunion( int a, int b){
        id[root(b)] = root(a);
    }
    static void wunion(int a , int b){

    }
   static boolean connected(int a , int b){
        return root(a) == root(b);
    }

    public static void main(String[] args) {
        length = 10;
        init(length);
        qunion(4,3);
        qunion(2,4);
        qunion(3,8);
        qunion(6,5);
        qunion(9,4);
        qunion(2,1);
        qunion(5,0);
        qunion(7,2);
        qunion(6,1);
        qunion(7,3);
        System.out.println("Quick-Union operations- Are these connected?"+connected(5,4));
        display(size);
//        init(length);
//        System.out.println("------------------------------------------");
//        System.out.println("Weight Quick-union:");


    }
}

