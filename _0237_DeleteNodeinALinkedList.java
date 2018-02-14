
package leetcode;

/**
 * Created by Edward.
 * 237. Delete Node in a Linked List
 */
public class _0237_DeleteNodeinALinkedList {
    /**
     * 
     Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
     the linked list should become 1 -> 2 -> 4 after calling your function.
     
     
     
     题意：
    	给点一个链表中的节点，删除这个节点，但该节点不能是最后一个节点

	 思路：
    
    	将该节点的值赋成其下一个节点的值，该节点的下一个节点指向原来下一节点的下一节点


	 复杂度：
     	时间 : O(1)
     	空间 : O(1)
     
     
     * @param node
     */

    public static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}