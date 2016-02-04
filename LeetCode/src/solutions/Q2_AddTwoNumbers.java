package solutions;


/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 *	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *	Output: 7 -> 0 -> 8
 * 
 * @author JT
 * @version August 4, 2015
 */

public class Q2_AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res, tempRes;
				
		res = this.addNodes(l1, l2);
		tempRes = res;
				
		//only one digit and the sum is over 10
		if (res.val >= 10) {
			tempRes.val = tempRes.val - 10;
			if (l1.next == null && l2.next == null) {
				tempRes.next = new ListNode(1);
			} else {
				if (l1.next != null) {
					l1.next.val++;
				} else {
					l2.next.val++;
				}
			}
		}
		
		l1 = l1.next == null ? null : l1.next;
		l2 = l2.next == null ? null : l2.next;
				
		while (l1 != null || l2 != null) {
			
			boolean overTen = false;
			
			ListNode nextNode = this.addNodes(l1, l2);
			
			if (nextNode.val >= 10) {
				nextNode.val = nextNode.val - 10;
				overTen = true;
			}
			
			tempRes.next = nextNode;
			tempRes = tempRes.next;
			
			if (!overTen) {
				l1 = l1 == null ? null : l1.next;
				l2 = l2 == null ? null : l2.next;
			} else {
				try {
					if (l1.next == null) {
						l1 = new ListNode(1);
					} else {
						l1.next.val++;
						l1 = l1.next;
					}
					l2 = l2 == null ? null : l2.next;
				} catch (Exception e) {
					if (l2.next == null) {
						l2 = new ListNode(1);
					} else {
						l2.next.val++;
						l2 = l2.next;
					}
					l1 = l1 == null ? null : l1.next;
				}
			}
		}
		
		return res;
	}
	
	private ListNode addNodes(ListNode l1, ListNode l2) {
		int curDigit;
		ListNode res;
		
		int dig1 = l1 == null ? 0 : l1.val;
		int dig2 = l2 == null ? 0 : l2.val;
		
		curDigit = dig1 + dig2;
		res = new ListNode(curDigit);
		
		return res;
	}
	
	public static void main(String[] args) {
		
		Q2_AddTwoNumbers at = new Q2_AddTwoNumbers();
		
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(3);
		
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(9);
		ListNode node7 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		
//		while (node1 != null) {
//			System.out.print(node1.val + "->");
//			node1 = node1.next;
//		}
//		
//		while (node4 != null) {
//			System.out.print(node4.val + "->");
//			node1 = node4.next;
//		}
		
		ListNode res = at.addTwoNumbers(node1, node4);
		
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}
