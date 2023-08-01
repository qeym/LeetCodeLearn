package hot100;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while(pA != null && pB != null){
            pA = pA.next;
            pB = pB.next;
        }
        ListNode oldPA = pB == null ? pA : pB;
        ListNode newPA = pB == null ? headA : headB;
        ListNode newPB = pB == null ? headB : headA;

        while(oldPA != null){
            oldPA = oldPA.next;
            newPA = newPA.next;
        }
        while (newPA != null && newPB != null){
            if(newPA == newPB) return newPA;
            newPA = newPA.next;
            newPB = newPB.next;
        }
        return null;
    }
}
