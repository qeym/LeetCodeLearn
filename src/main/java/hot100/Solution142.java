package hot100;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode first = head.next, second = head.next.next;
        boolean isCycle = false;
        while (first != null && second != null){
            if(first == second){
                isCycle = true;
                break;
            };
            first = first.next;
            if(second.next == null) break;
            second = second.next.next;
        }
        if(!isCycle) return null;
        ListNode newPoint = head;
        while (newPoint != first){
            newPoint = newPoint.next;
            first = first.next;
        }
        return newPoint;
    }
}
