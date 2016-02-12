package solutions;

/**
 * A class that generates linked list or tree for testing purpose
 * 
 *  * @author JT
 */

public class Construct {
	
	/**
	 * Generates a default linked list with 7 nodes in it
	 * @return
	 */
	public ListNode generateLinkedList() {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		
		return a1;
	}
	
	/**
	 * Generate a linked list with given nodes in the given order
	 * @param nodes the nodes to be inserted to a linked list (in this order)
	 * @return
	 */
	public ListNode generateLinkedList(ListNode... nodes) {
		for (int i=0; i < nodes.length - 1; i++) {
			nodes[i].next = nodes[i+1];
		}
		return nodes[0];
	}
	
	/**
	 * Prints a linked list given its head;
	 * @param node head of the linked list
	 */
	public void printLinkedList(ListNode node) {
		while (node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val);
	}
	
	
	/**
	 * Generates a default binary tree with 7 nodes in it
	 * @return
	 */
	public TreeNode generateTree() {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);

		
		a1.left = a2;
		a1.right = a3;

		a2.left = a4;
		a2.right = a5;

		a3.left = a6;
		a3.right = a7;

		return a1;
	}
	
}
