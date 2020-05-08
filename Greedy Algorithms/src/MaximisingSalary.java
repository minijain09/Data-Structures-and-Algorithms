import java.util.Scanner;

public class MaximisingSalary {

	public static int greater(int a, int b)
	{
		if (a<10 && b<10)
			return Math.max(a,b);
		int sum1=0;
		int i=0;
		int m=a; int n=b;
		while (a!=0)
		{
			sum1=sum1+(int)(Math.pow(10, i)*(a%10));
			a=a/10;
			i++;
		}
		while (b!=0)
		{
			sum1=sum1+(int)(Math.pow(10, i)*(b%10));
			b=b/10;
			i++;
		}
		int sum2=0;
		i=0;
		a=m; b=n;
		while (b!=0)
		{
			sum2=sum2+(int)(Math.pow(10, i)*(b%10));
			b=b/10;
			i++;
		}
		while (a!=0)
		{
			sum2=sum2+(int)(Math.pow(10, i)*(a%10));
			a=a/10;
			i++;
		}
		if (sum1>sum2)
			return n;
		else
			return m;
	}
	
	public static int numberofdigits(int n)
	{
		int count=0;
		while (n>0)
		{
			n=n/10;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)
        	arr[i]=s.nextInt();
        for (int i=0;i<n-1;i++)
        {
        	for (int j=0;j<n-i-1;j++)
        	{
        		if (arr[j]==greater(arr[j],arr[j+1]))
        		{
        			//swap
        			//System.out.println(arr[j]+" "+greater(arr[j+1],arr[j]));
        			int  temp=arr[j];
        			arr[j]=arr[j+1];
        			arr[j+1]=temp;
        		}
        	}
        }
       //System.out.println(greater(2,21));
        String ans="";
        for (int h=arr.length-1;h>=0;h--)
        	ans=ans+Integer.toString(arr[h]);
        System.out.println(ans);
	}

}
