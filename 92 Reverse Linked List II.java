题意：
    给定一个链表，发转从m到n之间的节点

思路：
    
    先找到节点m，再从m逐个反转节点，直到节点n


复杂度：
     time : O(n)
     space : O(1)



class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        	ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode pre = dummy;
	        ListNode cur = dummy.next;
	        for (int i = 1; i < m; i++) {
	            cur = cur.next;
	            pre = pre.next;
	        }
	        for (int i = 0; i < n - m; i++) {
	            ListNode temp = cur.next;
	            cur.next = temp.next;
	            temp.next = pre.next;
	            pre.next = temp;
	        }
	        return dummy.next;
	    }
}
