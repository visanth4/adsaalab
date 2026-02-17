import java.util.*;
class BFSMatrix{
      int vertices;
      int[][] adjmat;
      BFSMatrix(int v){
             vertices=v;
             adjmat=new int[v][v];
      }
      void addEdge(int src,int dest){
              adjmat[src] [dest]=1;
              adjmat[dest][src]=1;
      }
      void bfs(int start){
              boolean[] visited=new boolean[vertices];
              Queue<Integer> que=new LinkedList<>();
              visited[start]=true;
              que.add(start);
              System.out.println("BFS traversal");
              while(!que.isEmpty()){
                    int node=que.poll();
                    System.out.print(node+"");
                    for(int i=0;i<vertices;i++){
                        if(adjmat[node][i]==1&&visited[i]!=true){
                             visited[i]=true;
                             que.add(i);
                        }
                    }
              }
      
      }
      public static void main(String args[]){
           BFSMatrix obj=new BFSMatrix(5);
           obj.addEdge(0,1);
           obj.addEdge(2,1);
           obj.addEdge(2,2);
           obj.addEdge(2,3);
           obj.bfs(2);
      }
}
