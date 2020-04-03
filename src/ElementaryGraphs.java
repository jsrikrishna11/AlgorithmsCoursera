class AdjList{
    int vertix;
    AdjList[] link;
    int filled;
    AdjList(int vertix, int len){
        this.vertix = vertix;
        this.link = new AdjList[len];
        this.filled = 1;
        this.link[0] = this;
    }
    void connect(AdjList node){
        this.link[filled] = node;
        this.filled++;
        node.link[node.filled] = this;
        node.filled++;
    }
}
public class ElementaryGraphs {
    static boolean[][] mapAdj;
    static int _len;

    static void initAdj(int nVertices){
        _len = nVertices;
        mapAdj = new boolean[nVertices][nVertices];
        for(int i =0; i<nVertices; i++){
            for(int j = 0; j<nVertices;j++){
                mapAdj[i][j]= i==j? true:false;
            }
        }
    }
    static void displayMap(){
        System.out.print("\t ");
        for(int i = 0; i<_len;i++) {
            System.out.print(i);
            System.out.print("\t   ");
        }
        System.out.print("\n");
        for (int i=0; i<_len;i++){
            System.out.print(i);
            System.out.print("\t");
            for(int j =0 ; j< _len;j++){
                System.out.print(mapAdj[i][j]);
                System.out.print("  ");
            }
            System.out.println("\n ---------------------------------------------");
        }
    }
    static void connect(int vA, int vB){
        mapAdj[vA][vB]= true;
        mapAdj[vB][vA]=true;
    }
    public static void main(String args[]){
        initAdj(5);
        connect(1,3);
        displayMap();
        //Adjacency list.
        int nV = 7;
        AdjList first = new AdjList(1,nV);
        AdjList temp = new AdjList(2,nV);
        first.connect(temp);

        System.out.print("Done!");
    }
}
