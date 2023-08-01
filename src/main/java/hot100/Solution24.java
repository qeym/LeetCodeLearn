package hot100;

public class Solution24 {
    public static void main(String[] args) {
        ListNode input = new ListNode(new int[]{1,2,3,4,5,6});
        ListNode listNode = new Solution24().reverseKGroup(input, 2);
        listNode.print();

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ans.next = head;

        ListNode cur = ans;
        while (cur != null && cur.next != null){
            ListNode leftNode = cur;
            ListNode newLast = cur.next;

            ListNode last = cur;
            cur = cur.next;
            ListNode next = cur.next;

            boolean doReverse = false;
            for(int i  = 0 ; i < k ; i++){
                cur.next = last;

                last = cur;
                cur = next;
                if(cur == null && i != k - 1){
                    doReverse = true;
                    break;
                }
                if(cur != null)  next = cur.next;

            }
            if(doReverse){
                ListNode p = last, q = cur;
                while (p != leftNode && p != null){
                    ListNode temp = p.next;
                    p.next = q;

                    q = p;
                    p = temp;
                }
                break;
            }

            leftNode.next = last;
            newLast.next = cur;
            cur = newLast;
        }
        return ans.next;
    }
}
