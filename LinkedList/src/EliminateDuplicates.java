
public class EliminateDuplicates {

	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
	      LinkedListNode<Integer> temp=head;
	      while (temp.next!=null)
	      {
	        LinkedListNode<Integer> node=temp.next;
	        if (temp.data.intValue()==node.data.intValue())
	        {
	          
	          if (node.next==null)
	          {
	            temp.next=null;
	            return head;
	          }
	          temp.next=node.next;
	        }
	        else
	        {
	          temp=temp.next;
	        }
	      }
	      return head;
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> node1=new LinkedListNode<>(281);
		LinkedListNode<Integer> node2=new LinkedListNode<>(386);
		LinkedListNode<Integer> node3=new LinkedListNode<>(386);
		LinkedListNode<Integer> node4=new LinkedListNode<>(1212);
		LinkedListNode<Integer> node5=new LinkedListNode<>(1405);
		LinkedListNode<Integer> node6=new LinkedListNode<>(1405);
		LinkedListNode<Integer> node7=new LinkedListNode<>(1405);
		LinkedListNode<Integer> node8=new LinkedListNode<>(1405);
		LinkedListNode<Integer> node9=new LinkedListNode<>(1723);
		//1212 1405 1405 1405 1723 1913 -1
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		node8.next=node9;
		LinkedListNode<Integer> head=removeDuplicates(node1);
		while (head!=null)
		{
			System.out.println(head.data);
			head=head.next;
		}
	}

}
