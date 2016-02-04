package solutions;

public class Q110_BalancedBinaryTree {


	//O(nlogn); Master theory: a=2, b=2, d=1
	public boolean isBalanced(TreeNode root) {
		if (root == null) 
			return true;
		int diff = Math.abs(depth(root.left) - depth(root.right));
		if (diff > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	// O(n); Master theory: a=2, b=2, d=0
	public int depth(TreeNode node) {
		if (node == null) 
			return 0;
		return Math.max(1 + depth(node.left), 1 + depth(node.right));
	}


	public int checkHeight(TreeNode node) {
		if (node == null) 
			return 0;
		
		int leftH = checkHeight(node.left);
		if (leftH == -1)
			return -1;
		
		int rightH = checkHeight(node.right);
		if (rightH == -1)
			return -1;

		int diff = Math.abs(leftH - rightH);
		if (diff > 1)
			return -1;
		else 
			return Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;
	}

	public boolean isBalanced2(TreeNode root) {
		return checkHeight(root) != -1;
	}

	
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(5);
		TreeNode a2 = new TreeNode(5);
		TreeNode a3 = new TreeNode(5);
		TreeNode a4 = new TreeNode(5);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(5);
		TreeNode a7 = new TreeNode(5);
		TreeNode a8 = new TreeNode(5);
		TreeNode a9 = new TreeNode(5);

		a1.left = a2;
		a1.right = a3;

		a2.left = a4;
		a2.right = a5;

		a3.left = a6;
		a3.right = a7;

		a4.left = a8;
		a8.left = a9;

		Q110_BalancedBinaryTree q = new Q110_BalancedBinaryTree();
		System.out.println(q.isBalanced2(a1));

	}
}
