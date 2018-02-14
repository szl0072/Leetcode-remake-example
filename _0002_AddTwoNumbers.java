package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : AddTwoNumbers
 * Creator : Edward
 * Description : 2. Add Two Numbers
 */
public class _0002_AddTwoNumbers {
    /**
     * 

     You are given two non-empty linked lists representing two non-negative integers. T
     he digits are stored in reverse order and each of their nodes contain a single digit. 
     Add the two numbers and return it as a linked list.

	 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 
	 Example 
	 
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     
     题意：
    	给定两个链表，每个链表代表一个整数，返回两个整数相加后的链表表达式

	 思路：
    	1. 设置一个辅助节点dummy，以及一个移动节点cur，cur = dummy
    	2. 为了不改变输入，设置了两个新的链表p1和p2，指向原来的l1和l2
    	3. 设置一个变量sum，用来记录每个新节点的值，只要两个链表还有一个不为空，进行以下循环：
    	   a.  如果两个节点中任何节点不为空，则讲其值累加到sum上，并移动到下一节点
    	   b.  将得到的sum值 % 10 作为当前节点的值
    	   c.  sum重新赋值为 sum / 10, 为进位值
    	4. 如果最后的sum值为1，则需要增加一个新节点，值为1
   		5. 返回dummy.next
    	

	 复杂度：
     	时间 : O(n)
     	空间 : O(n)

     
     
     
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
