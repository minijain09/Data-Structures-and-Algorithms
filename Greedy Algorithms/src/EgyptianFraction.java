import java.util.*;

public class EgyptianFraction {
	
    public static int gcd(int a, int b)
    {
    	if (b == 0) 
            return a; 
        return gcd(b, a % b);  
    }

	public static void egyptian(int n, int d) {
		if (n <= 0 ||  d<=0)
			return;
		if (n==1)
		{
			System.out.print("1/" + d + " +");
			return;
		}
		//System.out.println("N: "+n +" D: "+d);
		int x = (d / n)+1;
		System.out.print("1/" + x + " +");
		n=(n * x) - d;
		d=d*x;
		int gcd=gcd(n,d);
		n=n/gcd;
		d=d/gcd;
		egyptian(n, d);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 14;
		int d = 6;
		if (n > d) {
			int count = n / d;
			int x = count;
			while (count > 0)
			{
				System.out.print("1 +");
				count--;
			}
			n = n - (d * x);
			int gcd=gcd(n,d);
			n=n/gcd;
			d=d/gcd;
		}
		egyptian(n, d);
	}
}
