
public class Solution {

	static class StackEmptyException extends Exception
	{

	}
	
	

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}

	static class Stack<T> {
		
		private int top;
	    private Node<T> head;
	    private Node<T> tail;
	  
	  public Stack() {
	       top=-1;
	       head=null;
	       tail=null;
		}
		
		public int size() {
	      int size=0;
	      Node<T> temp=head;
	      while (temp!=null)
	      {
	        size++;
	        temp=temp.next;
	      }
	      return size;
		}
		
		public void push(T data) {
	      
	      if (size()==0)
	      {
	        head=new Node<T>(data);
	        tail=head;
	      }
	      else
	      {
	        Node<T> temp=new Node<T>(data);
	        tail.next=temp;
	        tail=tail.next;
	      }

		}
		
		public boolean isEmpty() {
	        return (size()==0);
		}
		
		public T pop() throws StackEmptyException {
	      if (isEmpty())
	      {
	        StackEmptyException e=new StackEmptyException();
	        throw e;
	      }
	      else
	      {
	        T val=tail.data;
	        Node<T> temp=head;
	        while (temp.next!=tail)
	        {
	          temp=temp.next;
	        }
	        temp.next=null;
	        tail=temp;
	        return val;
	      }
		}
		
		public T top() throws StackEmptyException {
	       if (isEmpty())
	       {
	         StackEmptyException e=new StackEmptyException();
	         throw e;
	       }
	      else
	      {
	        return tail.data;
	      }
		}
	}
	
	public static boolean checkBalanced(String str) {
		// Write your code here
         Stack<Character> stack=new Stack<>();
         for (int i=0;i<str.length();i++)
         {
           if (str.charAt(i)=='{' || str.charAt(i)=='('|| str.charAt(i)=='[' )
           {
             stack.push(str.charAt(i));
           }
           if (str.charAt(i)=='}' || str.charAt(i)==')'|| str.charAt(i)==']' )
             {
               Character c;   
        	   try
                  {
                	  c= stack.pop();
                	  if (str.charAt(i)=='(')
                      {
                        if (c!=')')
                          return false;
                      }
                      else if (str.charAt(i)=='{')
                      {
                        if (c!='}')
                          return false;
                      }
                      else if (str.charAt(i)=='[')
                      {
                        if (c!=']')
                          return false;
                      }
                  }
                  catch (StackEmptyException e)
                  {//Never reach
                  }
               
             }
         }
         if (stack.size()==0)
         	return true;
         else
            return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		    

	}

}
}
