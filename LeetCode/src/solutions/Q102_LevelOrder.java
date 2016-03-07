package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_LevelOrder {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> curLevel = new ArrayList<Integer>();
			Queue<TreeNode> temp = new LinkedList<TreeNode>();

			while (!q.isEmpty()) {
				TreeNode curNode = q.remove();
				curLevel.add(curNode.val);
				if (curNode.left != null) {
					temp.add(curNode.left);
				}
				if (curNode.right != null) {
					temp.add(curNode.right);
				}
			}
			q.addAll(temp);
			result.add(curLevel);
		}
		return result;
	}
	
}
