package solutions;


/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are 
 * talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * Example:
 * 
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 
 * @author JT
 *
 */
public class Q328_oddEvenList {
	
    public ListNode oddEvenList(ListNode head) {
    	if (head == null) {
    		return null;
    	}
        ListNode oddList = head;
        ListNode evenList = head.next;
        
        ListNode oddHead = oddList;
        ListNode evenHead = evenList;
        
        while (evenList != null && evenList.next != null) {
        	oddList.next = oddList.next.next;
        	evenList.next = evenList.next.next;
        	
        	oddList = oddList.next;
        	evenList = evenList.next;
        }
        
        oddList.next = evenHead;
        return oddHead;
    }
}
