package solutions;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author JT
 *
 */
public class Q100_SameTree {

	//The idea is simple here, just check if current nodes are the same,
	//and recurse on their children
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if ((p == null && q != null) || ((p != null) && (q == null) )) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);  
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Q100_SameTree q = new Q100_SameTree();
		Construct c = new Construct();
		TreeNode t1 = c.generateTree();
		TreeNode t2 = c.generateTree();
		
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		
		a1.left = a2;
		a1.right = a3;
		
		TreeNode a4 = new TreeNode(1);
		TreeNode a5 = new TreeNode(2);
		TreeNode a6 = new TreeNode(3);
		
		a4.left = a6;
		a4.right = a5;
		
		System.out.println(q.isSameTree(t1, t2));
		System.out.println(q.isSameTree(a1, a4));

	}

}
