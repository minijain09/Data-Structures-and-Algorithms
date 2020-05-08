import java.util.Scanner;

public class TreeNodeUse {
	
	public static void printAtK(TreeNode<Integer> root, int k) {
		if (k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}
	
	public static int height(TreeNode<Integer> root){
	      if (root==null)
	        return 0;
	      QueueUsingLL<TreeNode<Integer>> queue=new QueueUsingLL<>();
	        queue.enqueue(root);
	        int count=0;
	      while (!queue.isEmpty())
	      {
	        count++;
	        int size=queue.size();
	        for (int i=0;i<size;i++)
	        {
	          try
	          {
	            TreeNode<Integer> node=queue.dequeue();
	          for (int j=0;j<node.children.size();j++)
	          {
	            queue.enqueue(node.children.get(j));
	          }
	          }
	          catch (QueueEmptyException e)
	          {
	            return count;
	          }
	        }
	        
	      }
	      return count;
	    }
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		// Write your code here
      int sum=sum(root);
      TreeNode<Integer> node=new TreeNode<Integer>(Integer.MIN_VALUE);
      for (int i=0;i<root.children.size();i++)
      {
        TreeNode<Integer> temp=maxSumNode(root.children.get(i));
        if (sum>sum(temp))
          node=root;
        else
          node=temp;
      }
      return node;
	}
	
  public static int sum(TreeNode<Integer> root)
  {
   int sum=root.data;
      for (int i=0;i<root.children.size();i++)
      {
        sum=sum+root.children.get(i).data;
      }
    return sum;
  }
	
	public static int countLeafNodes(TreeNode<Integer> root){
	      if (root.children.size()==0)
	        return 1;
	      int count=0;
	      if (root.children.size()!=0)
	      {
	        for (int i=0;i<root.children.size();i++)
	        {
	          count=count+ countLeafNodes(root.children.get(i));
	        }
	      }
	      return count;
		}
	
	public static int largest(TreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		int ans = root.data;
		for (int i = 0; i < root.children.size(); i++) {	
			int childLargest = largest(root.children.get(i));
			if (childLargest > ans) {
				ans = childLargest;
			}
		}
		return ans;
	}
	
	public static int numNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static TreeNode<Integer> takeInput(Scanner s) {
		int n;
		System.out.println("Enter next node data");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n, int x){
	      TreeNode<Integer> ans=null;
	      if (root.data>n && root.data<=x)
	      {
	        x=root.data;
	        ans=root;
	      }
	      for (int i=0;i<root.children.size();i++)
	      {
	        if (findNextLargerNode(root.children.get(i),n,x)!=null)
	          ans=findNextLargerNode(root.children.get(i),n,x);
	      }
	      return ans;

		}
	  
	  public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
	      return findNextLargerNode(root,n,root.data);
	  
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
	
	public static void main(String[] args) {
//		Scanner s= new Scanner(System.in);
//		
//		TreeNode<Integer> root = takeInput(s);
		TreeNode<Integer> root = takeInputLevelWise();
		//print(root);
//		System.out.println(largest(root));
	//	System.out.println(numNodes(root));
		//printAtK(root, 2);
		//System.out.println();
		TreeNode<Integer> ans=findNextLargerNode(root,4);
		if (ans!=null)
	      System.out.println(ans.data);
	}
}
