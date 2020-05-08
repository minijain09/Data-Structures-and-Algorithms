import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MaxLoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner s=new Scanner(System.in);
        int noi=s.nextInt();
        int tw=s.nextInt();
        float arr[][]=new float[noi][2];
        float ans=0;
        for (int i=0;i<noi;i++)
        {
        	int val=s.nextInt();
        	int w=s.nextInt();
        	arr[i][0]=((float)val)/w;
        	arr[i][1]=w;
        }
        for (int i=0;i<noi-1;i++)
        {
        	for (int j=0;j<noi-1-i;j++)
        	{
        		if (arr[j][0]<arr[j+1][0])
        		{
        			//swap
        			float temp=arr[j][0];
        			arr[j][0]=arr[j+1][0];
        			arr[j+1][0]=temp;
        			temp=arr[j][1];
        			arr[j][1]=arr[j+1][1];
        			arr[j+1][1]=temp;
        			
        		}
        	}
        }      //now arr of val/ per unit weight and total weight is sorted in descending order
        int i=0;
        while (tw!=0 && i<noi)
        {
        	if (arr[i][1]<=tw)
        	{
        		ans=ans+arr[i][0]*arr[i][1];
        		tw=tw-(int)arr[i][1];
        	}
        	else
        	{
        		ans=ans+arr[i][0]*tw;
        		tw=tw-tw;
        	}
        	i++;
        }
        DecimalFormat df=new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(ans));
    }

}
