import java.util.*;
public class ActivitySelectionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while (t>0)
		{
			int n=s.nextInt();
			int start[]=new int[n];
	        int finish[]=new int[n];
	        for (int i=0;i<n;i++)
	        	start[i]=s.nextInt();
	        for (int i=0;i<n;i++)
	        	finish[i]=s.nextInt();
			t--;
		}
	}

}
