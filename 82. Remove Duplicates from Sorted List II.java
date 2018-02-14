     题意：
    	给定一个排好序的链表，如果元素重复，则删除所有的这些元素，只留下原链表中出现一次的节点

	 思路：
    	1. 设置一个辅助节点dummy，让其next指向head，设置另外一个移动节点，让其指向dummy
    	2. 遍历整个链表，如果next的值和其后面的值相同，将当前节点的next指向next的next，当前节点不动 （实现删除）
    	3. 如果当前节点的值和下一节点的值不同，移动当前节点
    	4. 返回新的头结点

	 复杂度：
     	时间 : O(n)
     	空间 : O(1)



class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next !=null) {
            if (p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while (p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}