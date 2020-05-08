import java.util.Scanner;
public class MaxNumOfPrizes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int k=0;
        int counter=1;
        while (n!=0)
        {
        	if (counter+1<=n-counter)
        	{
        		n=n-counter;
        		counter++;
        	}
        	else
        		break;
        }
        System.out.println(counter);
	}
}
