//dijkstra implemention using matrix
import  java.util.*;
public class SSSP{
	static void dijkstra(int[][] graph,int source){
        	int n=graph.length;
        	int[] dist=new int[n];
        	boolean[] visited=new boolean[n];
        	for(int i=0;i<n;i++){
        		dist[i]=Integer.MAX_VALUE;
        	}
        	dist[source]=0;
        	for(int count=0;count<n-1;count++){
        		int min=Integer.MAX_VALUE;
        		int u=-1;
        		for(int i=0;i<n;i++){
        			if(!visited[i]&&dist[i]<min){
        				min=dist[i];
        				u=i;
        			}
        		}
        		visited[u]=true;
        		for(int v=0;v<n;v++){
        			if(!visited[v]&&graph[u][v]!=0&&dist[u]+graph[u][v]<dist[v]){
        				dist[v]=dist[u]+graph[u][v];
        			}
        		}
        	}
        	System.out.println("shortest paths");
        	for(int i=0;i<n;i++){
        		System.out.println("0 to "+i+" is "+dist[i]);
        	}
        } 
        public static void main(String args[]){
        	int[][] graph={
			{0,2,4,0},
			{2,0,1,7},
			{4,1,0,3},
			{0,7,3,0}        	
        	};
        	dijkstra(graph,0);
        }
}
