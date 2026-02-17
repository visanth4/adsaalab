class DFSMatrix{
      int vertices;
      int[][] adjMatrix;
      boolean[] visited;
      DFSMatrix(int v){
          vertices=v;
          adjMatrix=new int[v][v];
          visited=new boolean[v];
      }
      void addEdge(int i,int j){
          adjMatrix[i] [j]=1;
          adjMatrix[j][i]=1;
      }
      void dfs(int node){
          visited[node]=true;
          System.out.print(node+" ");
          for(int i=0;i<vertices;i++){
              if(adjMatrix[node][i]==1&&!visited[i]){
                 dfs(i);
              }
          }
      }
      public static void main(String args[]){
            DFSMatrix o=new DFSMatrix(5);
            o.addEdge(0,1);
            o.addEdge(2,3);
            o.addEdge(2,1);
            o.addEdge(2,2);
            System.out.print("DFS Traversal:");
            o.dfs(0);
            
      }
}
