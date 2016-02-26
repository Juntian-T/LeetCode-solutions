package solutions;

/**
 * Reverse a singly linked list.
 * 
 * @author JT
 */

public class Q206_ReverseLinkedList {


	//Recursive version
	public ListNode reverseList(ListNode head) {
		return reverseLinkedList(head, null);
	}

	//1 -> 2 -> 3
	public ListNode reverseLinkedList(ListNode head, ListNode newHead) {
		if (head == null) {
			return newHead;
		}
		ListNode next = head.next; //next: 2 -> 3 
		head.next = newHead; 	   //head: 1 -> null
		return reverseLinkedList(next, head); 
	}

	//
	public ListNode reverseList2(ListNode head) {
		ListNode newHead = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}

		return newHead;
	}
}
