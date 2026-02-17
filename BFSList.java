import java.util.*;
class BFSList{
      int vertices;
      ArrayList<ArrayList<Integer>>adjList;
      BFSList(int v){
           vertices=v;
           adjList=new ArrayList<>();
           for(int i=0;i<v;i++){
               adjList.add(new ArrayList<>());
           }
      }
      void addEdge(int src,int dest){
           adjList.get(src).add(dest);
           adjList.get(dest).add(src);
      }
      void bfs(int start){
           boolean[] visited=new boolean[vertices];
           Queue<Integer> que=new LinkedList<>();
           visited[start]=true;
           que.add(start);
           System.out.println("bes traversal");
           while(!que.isEmpty()){
                 int node=que.poll();
                 System.out.print(node+"");
                 for(int i:adjList.get(node)){
                      if(!visited[i]){
                          visited[i]=true;
                          que.add(i);
                      }
                 }
           }
      }
      public static void main(String[] args){
             BFSList o=new BFSList(5);
             o.addEdge(0,1);
             o.addEdge(0,2);
             o.addEdge(1,3);
             o.addEdge(1,4);
             o.bfs(4);
      }
}
