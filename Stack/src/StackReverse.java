import java.util.Stack;
public class StackReverse {

		public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
			for (int i=0;i<s1.size();i++)
		 {
			 Integer top=s1.pop();
			 for (int j=0;j<s1.size()-i;j++)
			 {
				 Integer a=s1.pop();
				 s2.push(a);
			 }
			 s1.push(top);
			 for (int k=0;k<s2.size();k++)
			 {
				 Integer a=s2.pop();
				 s1.push(a);
			 }
		 }
	      
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        reverseStack(s1,s2);
        for (int i=0;i<s1.size();i++)
        {
        	System.out.print(s1.pop()+" ");
        }
	}

}
