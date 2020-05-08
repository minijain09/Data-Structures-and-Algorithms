import java.util.Scanner;

public class SortEvenOdd {

	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> newhead=null;
        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer> tempnext;
        while (temp!=null)
        {
          if (temp.data%2!=0)
          {
            if (newhead==null)
            {
              tempnext=new LinkedListNode<>(temp.data);
              newhead=temp;
            }
            else
            {
              tempnext=new LinkedListNode<>(temp.data);
              newhead.next=tempnext;
              newhead=newhead.next;
            }
          }
          temp=temp.next;
        }
      while (head!=null)
        {
          if (head.data%2!=0)
          {
            if (newhead==null)
            {
              tempnext=new LinkedListNode<>(temp.data);
              newhead=temp;
            }
            else
            {
              tempnext=new LinkedListNode<>(head.data);
              newhead.next=tempnext;
              newhead=newhead.next;
            }
          }
          head=head.next;
        }
      return newhead;

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
        head=sortEvenOdd(head);
        print(head);
	}

}
