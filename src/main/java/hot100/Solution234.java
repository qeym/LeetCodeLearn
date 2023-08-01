package hot100;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int len = 0 ;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int mid = len/2;
        boolean isEven = len%2 == 0;
        cur = head;

        ListNode last = null;
        for(int i  = 0; i < mid ; i++){
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }

        ListNode leftHead = last;
        ListNode rightHead = isEven ? cur: cur.next;

        while (leftHead != null && rightHead != null){
            if(leftHead.val != rightHead.val) return false;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }
}
