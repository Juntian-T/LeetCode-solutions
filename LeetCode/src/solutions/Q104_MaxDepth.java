package solutions;

import java.util.ArrayList;
import java.util.Stack;

public class Q104_MaxDepth {


	//Recursive implementation
	//T(n) = 2T(n/2) + 1 -> O(n)  
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0; 
			//Note this has to be 0 if the node itself is null
			//If the node has no children, then it should be 1 here
			//I got that part wrong first time
		}
		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
	}

	//Or could we use a stack, DFS?
	public int maxDepth2(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		ArrayList<TreeNode> visited = new ArrayList<TreeNode>(); 
		//Need to keep track of which node has been visited in the DFS

		s.push(root);
		visited.add(root);

		int maxDepth = 1;

		while (!s.isEmpty()) {
			TreeNode cur = s.peek();
			if ((cur.left == null || visited.contains(cur.left)) && 
					(cur.right == null || visited.contains(root.right))) {
				//maxDepth = s.size() > maxDepth ? s.size() : maxDepth;
				s.pop();
			} else {
				if (!visited.contains(cur.left) && cur.left != null) {
					s.push(cur.left);
					visited.add(cur.left);
				}
				if (!visited.contains(cur.right) && cur.right != null) {
					s.push(cur.right);
					visited.add(cur.right);
				}
				maxDepth++;
			}

			//reach an end

		}
		return maxDepth;
	}


	public static void main(String[] args) {
		Q104_MaxDepth q = new Q104_MaxDepth();

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

		a6.left = a8;
		a6.right = a9;

		System.out.println(q.maxDepth2(a1));

	}
}
