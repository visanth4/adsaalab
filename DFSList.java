import java.util.*;
class DFSList{
      int vertices;
      ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
      boolean[] visited;
      DFSList(int v){
          vertices=v;
          visited=new boolean[v];
          for(int i=0;i<v;i++)
              adjList.add(new ArrayList<>());
      }
      void addEdge(int i,int j){
           adjList.get(i).add(j);
           adjList.get(j).add(i);
      }
      void dfs(int node){
          visited[node]=true;
          System.out.print(node+" ");
          for(int i:adjList.get(node)){
              if(!visited[i]){          
                  dfs(i);
              }
          }
      }
      public static void main(String args[]){
            DFSList o=new DFSList(5);
            o.addEdge(0,1);
            o.addEdge(2,3);
            o.addEdge(2,1);
            o.addEdge(2,2);
            System.out.print("DFS Traversal:");
            o.dfs(0);
      }
}
















