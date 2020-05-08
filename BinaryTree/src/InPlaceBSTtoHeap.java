import java.util.*;
public class InPlaceBSTtoHeap {
	
	public static BinaryTreeNode<Integer> prev;
	public static BinaryTreeNode<Integer> head;

	public static void binaryTreeToLL(BinaryTreeNode<Integer> root)
	{
		if (root==null)
			return;
		BinaryTreeNode<Integer> left=root.left;
		BinaryTreeNode<Integer> right=root.right;
		binaryTreeToLL(left);
		root.left=null;
		root.right=null;
		//System.out.println("hello");
		
		if (head==null)
		{
			head=root;
			prev=head;
		}
		else
		{
			prev.right=root;
			prev=prev.right;
			prev.left=null;
			
		}
		binaryTreeToLL(right);
	}
	
	public static BinaryTreeNode<Integer> toheap(BinaryTreeNode<Integer> root)
	{
		if (root==null)
			return null;
		binaryTreeToLL(root);
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
		while (head!=null)
		{
			q.add(head);
			head=head.right;
		}
		while (!q.isEmpty())
		{
			BinaryTreeNode<Integer> temp=q.peek();
			q.poll();
			if (!q.isEmpty()) {
				temp.left=q.peek();
				temp.left.left=null;
				temp.left.right=null;
				q.poll();
			}
			if (!q.isEmpty()) {
				temp.right=q.peek();
				temp.left.left=null;
				temp.left.right=null;
				q.poll();
			}
		}
		return root;
 	}
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		prev=null;
		head=null;
		root=toheap(root);
		printTree(root);
	}

}
