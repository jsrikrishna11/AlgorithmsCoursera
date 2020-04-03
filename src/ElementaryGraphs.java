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
    static int[] visited;
    static int now;
    static void displayArray(int[] array){
        for( int i = 0; i<_len; i++) {

            System.out.print(array[i]);
            System.out.print(", ");
        }
    }
    static void initAdj(int nVertices){
        _len = nVertices;
        mapAdj = new boolean[nVertices][nVertices];
        for(int i =0; i<nVertices; i++){
            for(int j = 0; j<nVertices;j++){
                mapAdj[i][j]= i==j? true:false;
            }
        }
        visited = new int[_len];
        for(int i=0 ; i< nVertices; i++){
            visited[i] = 0;
        }
        now=0;
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
    static void visit(int vertex){
        now = now+1;
        visited[vertex]=now;
        System.out.println(vertex);
        for(int i=0; i<_len; i ++){
            if(mapAdj[vertex][i]) {
                if(visited[i]==0) {
                    visit(i);
                }
            }
        }
        
    }
    public static void main(String args[]){
        int nV = 7;
        initAdj(nV);
        //Adjacency list.
        connect(0,5);
        connect(0,6);
        connect(1,2);
        connect(2,3);
        connect(2,4);
        displayMap();
        for(int i = 0 ; i< _len; i++){
            if(visited[i]==0){
                visit(i);
            }

        }
        displayArray(visited);

    }
}
