package solutions;

/** Given a linked list, determine if it has a cycle in it.
 * 
 * @author JT
 *
 */

public final class Q141_LinkedListCycle {

	//Straight forward runner technique. 
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;

		ListNode first = head;
		ListNode second = head;

		while (second.next != null && second.next.next != null) {
			first = first.next;
			second = second.next.next;
			if (first == second) {
				return true;
			}
		}
		return false;
	}
}
