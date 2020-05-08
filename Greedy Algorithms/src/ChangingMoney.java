
public class ChangingMoney {

	public static int numberofcoins(int n)
	{
		if (n<5)
			return n;
		int count=0;
		while (n!=0)
		{
			if (n>=10)
			{
				count=count+n/10;
				n=n-((n/10)*10);
			}
			else if (n>=5)
			{
				count=count+n/5;
				n=n-((n/5)*5);
			}
			else
			{
				count=count+1;
				n=n-1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(numberofcoins(143));

	}

}
