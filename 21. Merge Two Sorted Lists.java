          
     题意：
    	给定两个排好序的链表，将他们合并成一个有序链表

	 思路：
	  方法一
    	1. 利用Mergesort的思想，遍历两个链表，谁小就先将谁取出，
    	2. 不断重复以上过程，知道其中一个链表为空
		3. 判断是否还有为处理的元素，将其接到上面的结果链表的尾巴上
		4. 返回新的结果链表

	 复杂度：
     	时间 : O(n)
     	空间 : O(1)


     
   	方法二：递归地归并
     
 		时间 : O(n);
 		空间 :O(n);
 	 
 class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2= l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
