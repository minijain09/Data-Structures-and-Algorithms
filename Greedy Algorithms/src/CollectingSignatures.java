import java.util.*;
import java.util.Scanner;

public class CollectingSignatures {
	
	public static void quickSort(int[][] input)
	  {
	    quickSort(input,0,input.length-1);
	  }
	  
		public static void quickSort(int[][] input, int si,int ei) {
	      if (si>=ei || si<0 || ei>input.length-1)
			return;
	      int pivotpos=pivot(input,si,ei);
	      quickSort(input,si,pivotpos-1);
	      quickSort(input,pivotpos+1,ei);
		}
		
	  public static int pivot(int input[][],int si,int ei)
	  {
	    int pivot=input[si][0];
	    int count=0;
	    for (int i=si+1;i<=ei;i++)
	    {
	      if (input[i][0]<=pivot)
	        count++;
	    }
	    int temp=input[si+count][0];
	    input[si+count][0]=input[si][0];
	    input[si][0]=temp;
	    temp=input[si+count][1];
	    input[si+count][1]=input[si][1];
	    input[si][1]=temp;
	    int i=si;
	    int j=ei;
	    while (i<si+count && j>si+count)
	    {
	      if (input[i][0]>pivot)
	      {
	        if (input[j][0]<=pivot)
	        { 
	        	int a=input[j][0];
	            input[j][0]=input[i][0];
	            input[i][0]=a;
	            a=input[j][1];
	            input[j][1]=input[i][1];
	            input[i][1]=a;
	            i++;
	            j--;
	        }
	      else
	        j--;
	      }
	      else
	        i++;
	    }
	    return si+count;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
	        int n=s.nextInt();
	        int arr[][]=new int[n][2];
	        int nod=0;
	        for (int k=0;k<n;k++)
	        {
	        	int i=s.nextInt();
	        	int j=s.nextInt();
	        	arr[k][0]=i;
	        	arr[k][1]=j;
	        } 
	        //input finish
	        quickSort(arr);
	        int i=0;
	        int countofdisjoint=1;
	        ArrayList<Integer> ans=new ArrayList<>();
	        while (i<n)
	        {
	        	//start of set
	        	int minend=arr[i][1];
	        	int k=i;
	        	int j=0;
	        	for (j=k+1;j<n;j++)
	        	{
	        		if (arr[j][0]>minend)
	        		{
	        			//set ends
	        			countofdisjoint++;
	        			break;
	        		}
	        		else if  (arr[j][1]<minend)
	        			minend=arr[j][1];
	        		i++;
	        	}
	        	//end of set
	        	ans.add(minend);
	        	i=j;
	        }
	        System.out.println(countofdisjoint);
	        for (int m=0;m<ans.size();m++)
	        	System.out.print(ans.get(m)+" ");
	}
}
