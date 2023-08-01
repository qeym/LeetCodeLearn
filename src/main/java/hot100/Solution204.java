package hot100;

public class Solution204 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode last = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }
}
