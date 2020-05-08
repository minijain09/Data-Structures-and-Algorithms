import java.util.Scanner;

class LinkedListNodes<T> {
	public T data;
	public LinkedListNodes<T> next;

	public LinkedListNodes(T data) {
		this.setData(data);
		this.next = null;
	}
    
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

public class ReverseLinkedList {

	public static LinkedListNodes<Integer> takeInput()
	{
		LinkedListNodes<Integer> head = null, tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
				
		while(data != -1){
			LinkedListNodes<Integer> newNode = new LinkedListNodes<Integer>(data);
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
	
public static void print(LinkedListNodes<Integer> head){
		
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();

	}
	

	
	public static LinkedListNodes<Integer> reverse_R(LinkedListNodes<Integer> head) {
		if (head.next==null)
	      return head;
	    LinkedListNodes<Integer> updatedhead=reverse_R(head.next);
	    head.next.next=head;
	    head.next=null;
	    return updatedhead;
		}
	
	public static int length(Node head)
	  {
	      int count=0;
	      while (head!=null)
	      {
	          head=head.next;
	          count++;
	      }
	      return count;
	  }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNodes<Integer> head = takeInput();
		head=reverse_R(head);
		print(head);
		int len=length(head);
		System.out.println(head);
	}

}
