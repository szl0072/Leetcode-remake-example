package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * Creator : Edward
 * 24. Swap Nodes in Pairs
 */
public class _0024_SwapNodesInPairs {
    /**
     * 
     * 
     Given a linked list, swap every two adjacent nodes and return its head.
     For example,
     Given 1->2->3->4, you should return the list as 2->1->4->3.
     
     
     
     题意：
    	给定一个链表，每两个临近节点交换位置

	 思路：
    	循环处理两个需要被交换的节点


	 复杂度：
     	时间 : O(n)
     	空间 : O(1)


     
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
