package leetcode;

import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PlusOneLinkedList
 * Creator : Edward
 * Description :  369. Plus One Linked List
 */
public class _0369_PlusOneLinkedList {
    /**
     *
     * 
     Input:
     1->2->3
     
     Output:
     1->2->4
     

     题意：
    	给定一个链表表示一个整数，每个节点为整数中的一个位，让该整数加一，返回新的链表表达式

	 思路：
	 	方法一：
    	1. 设置三个辅助节点i, j, 和dummy，他们的next均指向head
    	2. 遍历整个链表，i记录下最左边需要改变原val的节点，j移动遍历整个链表
    	3. 如果i所在的位置不是最后一个节点，那么它所在的位置的值应该加1，后面的节点值重置为0
    	4. 如果dummy的值改变为1，则返回dummy本身
    	5. 如果dummy的值为0，返回dummy.next
    	
    	方法二：
    	1. 反转链表
    	2. 遍历整个链表，给第一个节点的值加上1，后续节点根据前一个节点是否有carry而进行继续处理
    	3. 注意最后一个节点走完之后，carry为1的情况，需要增加一个节点
    	3. 反转并返回链表
    	

	 复杂度：
     	时间 : O(n)
     	空间 : O(1)




     * @param head
     * @return
     */

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) i = j;
        }
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }

    /**
     1 -> 0 -> 0 -> 0
     * @param head
     * @return
     */
    public ListNode plusOne2(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int carry = 1;
        while (carry > 0 || cur.next != null) {
            if (cur.next != null) {
                cur = cur.next;
                carry += cur.val;
                cur.val = carry % 10;
                carry /= 10;
            } else {
                cur.next = new ListNode(carry);
                cur = cur.next;
                carry = 0;
            }
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}