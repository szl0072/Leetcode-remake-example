题意：
    判断一个链表是否有环

思路：
    
    双指针，一快一慢，快指针每次走两步，慢指针走一步，如果二者相遇，则有环，如果快指针遇到null，则无环


复杂度：
     time : O(n)
     space : O(1)


public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}