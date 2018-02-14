package leetcode;

/**
 * Created by Edward on 25/07/2017.
 * 83. Remove Duplicates from Sorted List
 */
public class _0083_RemoveDuplicatesfromSortedList {
    /**
     * 
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
     
     
     题意：
    	给定一个排好序的链表，删除其中值是重复的节点, 使每个元素只出现一次

	 思路：
    	1. 设置一个辅助节点cur
    	2. 遍历整个链表，如果next的值和当前节点的值相同，将当前节点的next指向next的next，当前节点不动 （去除重复节点）
    	3. 如果当前节点的值和下一节点的值不同，移动当前节点
    	4. 返回新的头结点

	 复杂度：
     	时间 : O(n)
     	空间 : O(1)



     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
