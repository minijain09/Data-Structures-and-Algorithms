import java.util.Scanner;

public class DeleteRecursive {

	public static LinkedListNode<Integer> DeleteIthNodeRec(LinkedListNode<Integer> head, int i, int j)
	{
		if (i==0)
			return head.next;
		
		if (j==(i-1))
		{
			LinkedListNode< Integer> temp=head;
			int k=0;
			while (k!=j)
			{
				head=head.next;
				k++;
			}
			if (head==null)
				return head;
			if (head.next!=null)
			{
				head.next=head.next.next;
			}
			else
				head.next=null;
			return temp;
		}
		
		LinkedListNode<Integer> ans=DeleteIthNodeRec(head,i,j+1);
		return ans;
	}
	
	
	public static LinkedListNode<Integer> DeleteIthNodeRec(LinkedListNode<Integer> head, int i)
	{
		return DeleteIthNodeRec(head,i,0);
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
        head=DeleteIthNodeRec(head,0);
        print(head);
	}

}
