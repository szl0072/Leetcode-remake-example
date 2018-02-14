package leetcode;

/**
 * Created by Edward.
 * 206. Reverse Linked List
 */
public class _0206_ReverseLinkedList {
    /**
     *
     Reverse a singly linked list.
     
     
     题意：
    	给定一个链表，返回其反转后的结果

	 思路：
    	属于模拟题。
    	如果有元素，就将每个节点的next指向改变成其前面的节点


	 复杂度：
     	时间 : O(n)
     	空间 : O(1)

     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}