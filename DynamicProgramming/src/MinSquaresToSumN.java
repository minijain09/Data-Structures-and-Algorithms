
public class MinSquaresToSumN {

	public static int minCount(int n) {
		// Write your code here
      int storage[]=new int[n+1];
      storage[1]=1;
      storage[0]=0;
      for (int i=2;i<=n;i++)
      {
        int high=(int)(Math.sqrt(i));
        int min=Integer.MAX_VALUE;
        for (int j=1;j<=high;j++)
        {
          int count=1+storage[i-(j*j)];
          if (count<min)
            min=count;
        }
        storage[i]=min;
      }
      return storage[n];

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(minCount(12));
	}

}
