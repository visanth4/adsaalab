//merge sort
import java.util.*;
public class MergeSort1{
   void sort(int[] arr,int left, int right){
      if(left<right){
         int mid=left+(right-left)/2;
         sort(arr,left,mid);
         sort(arr,mid+1,right);
         merge(arr,left,mid,right);
      }
   }      
   void merge(int[] arr,int left,int mid,int right){
      int b[]=new int[arr.length];
      int i=left;
      int j=mid+1;
      int k=left;
      while(i<=mid && j<=right){
          if(arr[i]<=arr[j]){
             b[k]=arr[i];
             i=i+1;
          }
          else{
             b[k]=arr[j];
             j=j+1;
          }
          k=k+1;
      } 
      // when the any half sorted completly
      while(i<=mid){
          b[k]=arr[i];
          i++;
          k++;
      }
      while(j<=right){
          b[k]=arr[j];
          j++;
          k++;
      }
      for(int h=left;h<=right;h++){
         arr[h]=b[h];
      }
     /* if(i>mid){
         for(int h=j;h<=right;h++){
            b[k]=arr[h];
            k=k+1;
         }
      }
      else{
          for(int h=i;h<=mid;h++){
             b[k]=arr[h];
             k=k+1;
          }
      }*/

   }
   public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         System.out.println("enter the size of the array");
         int n=sc.nextInt(); 
         int[] arr=new int[n];
         for(int i=0;i<n;i++){
         System.out.println("enter the element");
            arr[i]=sc.nextInt();
         }
         MergeSort1 ms=new MergeSort1();
         ms.sort(arr,0,arr.length-1);
         System.out.println("sorted array is ");
         for(int x=0;x<arr.length;x++){
             System.out.print(arr[x]+" ");
         }
   
   }
}

