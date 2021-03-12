package xyz.anarres.leetcode.march;

import java.util.HashSet;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * 
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * 
 * 
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Each value on each linked list is in the range [1, 10^9].
    Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */


// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListsIntersection {

	public static void main(String[] args) {
		// tests
		LinkedListsIntersection intersection = new LinkedListsIntersection();
		// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		ListNode node = new ListNode(8);
		headA.next.next = node;
		node.next = new ListNode(4);
		node.next.next = new ListNode(5);
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(6);
		headB.next.next = new ListNode(1);
		headB.next.next.next = node;
		ListNode intersect = intersection.getIntersectionNode(headA, headB);
		System.out.println("Output: " + (intersect == null ? "null" : intersect.val));
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// OK lets use the platform, hm? HashSet will use more memory or nah
		// PSA: HashSet has constant time or almost for add(), contains(), remove()
		if (headA == null || headB == null)
			return null;
		
		HashSet<ListNode> nodes = new HashSet<ListNode>();
		do {
			nodes.add(headA);
			headA = headA.next;
		} while (headA != null);
		
		// the moment of truth
		do {
			if (!nodes.add(headB))
				return headB;
			headB = headB.next;
		} while (headB != null);
		
		return null;
	}

	public ListNode getIntersectionNodeWithInts(ListNode headA, ListNode headB) {
		// lets do integer comparisons as long as we can, instead of nodes
		
		if (headA == null || headB == null)
			return null;
		
		int sizeA = getSize(headA);
		do {
			int sizeB = getSize(headB);
			do {
				System.out.println("Comparing " + headA.val + " to " + headB.val);
				
				if (headA.val == headB.val && sizeA == sizeB && headA.equals(headB))
					return headA;
				if (sizeB <= sizeA) {
					// we're through with B, we can't get another suitable element
					break;
				}
				headB = headB.next;
				sizeB--;
			} while (headB != null);
			
			headA = headA.next;
			sizeA--;
		} while (headA != null);
		
		// not found
		return null;
	}

	/**
	 * Size of the list starting with node node
	 * @param node
	 * @return how many elements follow in the list
	 */
	private int getSize(ListNode node) {
		int size = 0;
		while (node.next != null) {
			size++;
			node = node.next;
		}
		return size;
	}
	
	public ListNode getIntersectionNodeDumb(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		
		// dumb solution, lets just do O(n^2)
		// traverse the first, for each node check the second
		ListNode nodeA = headA;
		do {
			ListNode nodeB = headB;
			do {
				System.out.println("Comparing " + nodeA.val + " to " + nodeB.val);
				if (nodeA.val == nodeB.val && !nodeA.equals(nodeB))
					System.out.println(nodeA +" != " + nodeB);
				if (nodeA.equals(nodeB))
					return nodeA;
				nodeB = nodeB.next;
			} while (nodeB != null);

			nodeA = nodeA.next;

		} while (nodeA != null);
		// not found
		return null;
	}

}
