package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RemoveNthNodeFromEndofList
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 19. Remove Nth Node From End of List
 */
public class _0019_RemoveNthNodeFromEndofList {
    /**
     *  
     Given linked list: 1->2->3->4->5, and n = 2.
     After removing the second node from the end, the linked list becomes 1->2->3->5.
  
     
          
     题意：
    	给定一个链表，删除倒数第n个节点，比如最后一个节点是倒数第一个节点

	 思路：
    	1. 初始化三个辅助节点，fast和slow以及dummy
    	2. 他们的下一节点都指向head
		3. 让fast节点先走n步
		4. slow和fast同时走，当fast走完链表时，slow走到了倒数第n个节点的前一个
		5. 讲slow的下一节点指向n的下一节点
		6. 返回dummy.next

	 复杂度：
     	时间 : O(n)
     	空间 : O(1)


     
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
