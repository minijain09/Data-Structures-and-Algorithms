import java.util.Scanner;

public class MergeSort {

	public static int length(LinkedListNode head)
	{
		int i=0;
		while (head!=null)
		{
			head=head.next;
			i++;
		}
		return i;
	}
	
	public static LinkedListNode<Integer> takeInput()
	{
		LinkedListNode<Integer> head = null, tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
				
		while(data != -1){
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}else{
//				LinkedListNodeNode<Integer> temp = head;
//				while(temp.next != null){
//					temp = temp.next;
//				}
//				temp.next = newNode;
				tail.next = newNode;
				tail = newNode; // tail = tail.next
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		// write your code here
      if (head.next==null || head==null)
        return head;
      LinkedListNode<Integer> temp=head.next;
      LinkedListNode<Integer> mid=head;
      while (temp!=null)
      {
        temp=temp.next;
        if (temp!=null)
          {
        	temp=temp.next;
          }
        else
          {
        	break;
          }
        mid=mid.next;
      }
      if (mid==null)
    	  return head;
      LinkedListNode<Integer> newmid=mid.next;
      mid.next=null;
      LinkedListNode<Integer> ans1=mergeSort(head);
      LinkedListNode<Integer> ans2=mergeSort(newmid);
      LinkedListNode<Integer> headfinal=merge(ans1,ans2);
      return headfinal;
    }
      
      
      public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
      	/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
      LinkedListNode<Integer> tail;
      LinkedListNode<Integer> head;
      if (head1==null)
        return head2;
      if (head2==null)
        return head1;
      if (head1.data.intValue()>head2.data.intValue())
      {
        head=head2;
        tail=head2;
        head2=head2.next;
      }
      else
      {
        head=head1;
        tail=head1;
        head1=head1.next;
      }
      
      while (head1!=null && head2!=null)
      {
        if (head1.data.intValue()<head2.data.intValue())
        {
          tail.next=head1;
          head1=head1.next;
        }
        else
        {
          tail.next=head2;
          head2=head2.next;
        }
        tail=tail.next;
      }
      while (head1!=null)
      {
        tail.next=head1;
        head1=head1.next;
      }
      while (head2!=null)
      {
        tail.next=head2;
        head2=head2.next;
      }
	   return head;
	}
      
      public static void print(LinkedListNode<Integer> head){
  		
  		while(head != null){
  			System.out.print(head.data +" ");
  			head = head.next;
  		}
  		System.out.println();

  	}
  	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedListNode<Integer> head=takeInput();
        head=mergeSort(head);
        print(head);
	}

}
