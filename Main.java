import java.util.LinkedList;
import java.util.Queue;

class GraphMatrix{
    private int vertices;
    private int[][] adjMatrix;
    GraphMatrix(int v){
        vertices=v;
        adjMatrix=new int [v][v];
    }
    void addEdge(int src,int dest){
        adjMatrix[src][dest]=1;
        adjMatrix[dest][src]=1;
    }
    void BFS(int start){
        boolean visited[]=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();
        visited[start]=true;
        queue.add(start);
        System.out.print("BFT (BFS): ");
        while(!queue.isEmpty()){
            int node=queue.poll();
            System.out.print(node+" ");
            for(int i=0;i<vertices;i++){
                if(adjMatrix[node][i]==1 && !visited[i]){
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }
    void DFS(int start){
        boolean visited[]=new boolean[vertices];
        System.out.print("DFT (DFS): ");
        DFSUtil(start,visited);
    }
    void DFSUtil(int start, boolean[] visited){
        visited[start]=true;
        System.out.print(start+" ");
        for(int i=0;i<vertices;i++){
            if(adjMatrix[start][i]==1 && !visited[i]){
                DFSUtil(i,visited);
            }
        }
    }
}
public class Main{
    public static void main(String[] args){
        GraphMatrix graph=new GraphMatrix(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.BFS(0);
        System.out.println();
        graph.DFS(0);
    }
}