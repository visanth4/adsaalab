//JobSequencing Implementation
import java.util.*;
class Job{
	int id;
        int deadline;
        int profit;
        Job(int id,int deadline,int profit){
		this.id=id;
        	this.deadline=deadline;
        	this.profit=profit;   
	}
}
public class VisJobSequencing{
	public static void main(String[] args){
		Job[] jobs={
			new Job(1,2,100),
			new Job(2,1,19),
			new Job(3,2,27),
			new Job(4,1,25),
			new Job(5,3,15)
		};
		int n=jobs.length;
		Job temp;
		//sorting jobs in descending order of profits
		 for(int i=0;i<n;i++)
		 	for(int j=0;j<n-1-i;j++){
		 		if(jobs[j].profit<jobs[j+1].profit){
		 	        	temp=jobs[j];
		 	        	jobs[j]=jobs[j+1];
		 	        	jobs[j+1]=temp;   		
		 		}
		 	}
		 for(int i=0;i<n-1;i++){
		 	System.out.println(jobs[i].profit);
		 }
		//Arrays.sort(jobs,(a,b)-> b.profit-a.profit);
		
		int maxDeadline=0;
		for(Job j:jobs)
			maxDeadline=Math.max(maxDeadline,j.deadline);
		int slot[]=new int [maxDeadline];
		boolean[] filled=new boolean[maxDeadline];
		int totalprofit=0;
		for(int i=0;i<n;i++)
			for(int j=jobs[i].deadline-1;j>=0;j--){
				if(!filled[j]){
					filled[j]=true;
					slot[j]=jobs[i].id;
					totalprofit+=jobs[j].profit;
					break;
				}
			}
		System.out.print("selected jobs are:");
	        for(int i=0;i<maxDeadline;i++){
			if(filled[i])
			System.out.print("\tjob"+jobs[i].id);
	}
		System.out.println("\nTotal Profit:\t"+totalprofit);
	}
		
}
