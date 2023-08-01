package hot100;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode first = head.next, second = head.next.next;
        while (first != null && second != null){
            if(first == second) return true;
            first = first.next;
            if(second.next == null) break;
            second = second.next.next;
        }
        return false;
    }
}
