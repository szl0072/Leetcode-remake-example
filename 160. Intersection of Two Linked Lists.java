     题意：
    	给定两个有共同元素的链表，找到共同元素的起点节点

	 思路：
	 	方法一：
    	1. 使用一个辅助函数计算两个链表的长度
    	2. 通过调整两个链表的长度，使得两个链表的新的头结点所代表的链表长度一致
    	3. 从新的两个头结点开始遍历，找到第一个相同的节点并返回

 

	 复杂度：
     	时间 : O(n)
     	空间 : O(1) 



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
           
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    
    }
    
    
    方法二：
   	1. 设置两个辅助链表a和b
		2. 遍历链表 （循环条件为 a != b）
		3. 如果链表的下一节点不为空，继续遍历
		4. 如果下一节点为空，则让下一节点指向另外一条链表
		5. 返回第一个相同的节点
   	
    
    时间 : O(m + n);
    空间 : O(1);
    
     
    
    
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}