    题意：
    	给定一个链表，将链表中的节点按奇数位置和偶数位置分开，奇数位置节点在前

	思路：
    	定义两个新的节点头，奇数节点指向原链表的头结点，偶数节点指向头结点的下一个节点
    	
    	使得两个链表分别链接奇数位置节点（1， 3， 5， 7）和偶数节点 （2， 4， 6， 8）
    	
    	将奇数链表的最后节点的尾部指向偶数链表的头
    	
    	返回重新排列过的头结点


	复杂度：
     	时间 : O(n)
     	空间 : O(1)


class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    
    }
}