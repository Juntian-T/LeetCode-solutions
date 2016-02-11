package solutions;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 * @author JT
 *
 */
public class Q237_DeleteNode {

	//The idea is simple, just copy the value of next node to current one
	public void deleteNode(ListNode node) {
		while (node.next != null) {
			node.val = node.next.val;
			if (node.next.next == null) {
				node.next = null;
				break;
			}
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Construct c = new Construct();
		
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		
		ListNode n = c.generateLinkedList(a1,a2,a3,a4,a5,a6,a7);
		
		Q237_DeleteNode q = new Q237_DeleteNode();
		q.deleteNode(a3);
		c.printLinkedList(n);
		
	}
}
