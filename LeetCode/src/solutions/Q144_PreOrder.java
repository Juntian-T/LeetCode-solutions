package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * @author JT
 */

public class Q144_PreOrder {
	//The idea is simple, just use a stack
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> path = new ArrayList<Integer>();
		if (root != null) {
			s.push(root);
		}
		while (!s.isEmpty()) {
			TreeNode cur = s.pop();
			path.add(cur.val);
			if (cur.right != null) s.push(cur.right); 
			if (cur.left != null) s.push(cur.left); 
		}
		return path;
	}
}
