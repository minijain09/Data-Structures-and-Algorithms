import java.util.*;
public class ThreeStacksEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s1=new Stack<>();
		Stack<Integer> s2=new Stack<>();
		Stack<Integer> s3=new Stack<>();
		int sum1=0;
		int sum2=0;
		int sum3=0;
		s1.add(1);
		s1.add(1);
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s2.add(2);
		s2.add(3);
		s2.add(4);
		s3.add(4);
		s3.add(1);
		s3.add(5);
		s3.add(2);
		//ans is 5
		for (int i : s1)
			sum1+=i;
		for (int i : s2)
			sum2+=i;
		for (int i : s3)
			sum3+=i;
		while (!(sum1==sum2 && sum1==sum3))
		{
			int max=Math.max(sum1, Math.max(sum2, sum3));
			if (s1.isEmpty()!=true && sum1==max)
			{
				sum1=sum1-s1.peek();
				s1.pop();
			}
			else if (s2.isEmpty()!=true && sum2==max)
			{
				sum2=sum2-s2.peek();
				s2.pop();
			}
			else if (s3.isEmpty()!=true && sum3==max)
			{
				sum3=sum3-s3.peek();
				s3.pop();
			}
		}
		System.out.println(sum1);
	}

}
