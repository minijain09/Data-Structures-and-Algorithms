import java.util.Scanner;

public class Test {

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
	

	
	public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
		if (head.next==null)
	      return head;
	    LinkedListNode<Integer> updatedhead=reverse_R(head.next);
	    head.next.next=head;
	    head.next=null;
	    return updatedhead;
		}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head = takeInput();
		head=reverse_R(head);
		print(head);
	}
}
