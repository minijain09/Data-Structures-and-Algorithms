import java.util.Scanner;

public class MergeLinkedLists {

	
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
	
	public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
      	/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
      LinkedListNode<Integer> tail;
      LinkedListNode<Integer> head;
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
      while (head1 != null)
      {
        tail.next=head1;
        head1=head1.next;
      }
      while (head2 != null)
      {
        tail.next=head2;
        head2=head2.next;
      }
      System.out.println(head1);
      System.out.println(head2);
	  return head;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedListNode<Integer> head1=takeInput();
        LinkedListNode<Integer> head2=takeInput();
        LinkedListNode<Integer> head=mergeTwoList(head1,head2);
        while (head!=null)
        {
        	System.out.println(head.data);
        	head=head.next;
        }
	}

}
