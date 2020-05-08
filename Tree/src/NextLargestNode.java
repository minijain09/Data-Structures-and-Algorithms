import java.util.Scanner;


class Queue<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;
  
  public Queue() {
       head=null;
       tail=null;
       size=0;
	}

	public void enqueue(T data) {
       if (size()==0)
       {
         Node<T> temp=new Node<>(data);
         head=temp;
         tail=temp;
       }
      else
      {
        Node<T> temp=new Node<>(data);
        tail.next=temp;
        tail=tail.next;
      }
      size++;
      return;
	}

	public int size() {
       return size;
	}

	public boolean isEmpty() {
       return (size==0);
	}

	public T dequeue() throws QueueEmptyException {
       if (size==0)
       {
         QueueEmptyException e=new QueueEmptyException();
         throw e;
       }
      else
      {
        T val=head.data;
        head=head.next;
        size--;
        return val;
      }
	}

	public T front() throws QueueEmptyException {
       if (size==0)
       {
         QueueEmptyException e=new QueueEmptyException();
         throw e;
       }
      else
      {
        return head.data;
      }
	}
}

public class NextLargestNode {

	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		  Queue<TreeNode<Integer>> queue=new Queue<>();
	      // Write your code here
	      while (!queue.isEmpty())
	      {
	        try
	        {
	          TreeNode<Integer> nodes=queue.dequeue();
	        if (nodes.data.intValue()>n)
	          return nodes;
	        for(int i=0;i<nodes.children.size();i++)
	        {
	          queue.enqueue(nodes.children.get(i));
	        }  
	        }
	        catch (QueueEmptyException e)
	        {
	          
	        }
	      }
	      return null;

		}
		
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of " + frontNode.data);
				int numChildren = s.nextInt();
				for (int i = 0; i < numChildren; i++) {
					System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (QueueEmptyException e) {
				// Shouldn't come here
				return null;
			}
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String s = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
        TreeNode<Integer> root=takeInputLevelWise();
        TreeNode<Integer> node=findNextLargerNode(root,18);
        if (node!=null)
        	System.out.println(node.data);
        else
        	System.out.println("-1");
	}

}
