package leetcode;

/**
 * Created by Edward.
 * 203. Remove Linked List Elements
 * 
 */
public class _0203_RemoveLinkedListElements {
    /**
     *
     Remove all elements from a linked list of integers that have value val.
     
     Example
     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     Return: 1 --> 2 --> 3 --> 4 --> 5
     Credits:
     Special thanks to @mithmatt for adding this problem and creating all test cases.
     
     题意：
    	给定一个链表，删除其中值为给定值的节点

	 思路：
	 	方法一：
    	1. 设置一个辅助节点dummy
    	2. 遍历整个链表，如果next的值和给定的值相同，将当前节点的next指向next的next，当前节点不动 （去除重复节点）
    	3. 如果当前节点的值和下一节点的值不同，移动当前节点
    	4. 返回dummy.next
    	
    	方法二：
    	1. 设置一个辅助节点p
    	2. 遍历整个链表，如果next的值和给定的值相同，将当前节点的next指向next的next，当前节点不动 （去除重复节点）
    	3. 如果当前节点的值和下一节点的值不同，移动当前节点
    	4. 最后判断头结点是否和给定值相同，如果相同，返回head.next，不同则返回head
    	
 

	 复杂度：
     	时间 : O(n)
     	空间 : O(1) 前两种方法，O(n) 递归

     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }
}
