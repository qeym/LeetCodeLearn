package hot100;

public class Solution2 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(new int[]{9,9,9,9,9,9,9});
        ListNode secondNode = new ListNode(new int[]{9,9,9,9});
        ListNode resutl = new Solution2().addTwoNumbers(firstNode, secondNode);
        resutl.print();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;

        int carry = 0;
        while (l1 != null || l2 != null){
            int num1, num2, sum;
            if(l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }else{
                num1 = 0;
            }

            if(l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }else{
                num2 = 0;
            }

            sum = num1 + num2 + carry;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            carry = sum/10;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }

        return ans.next;
    }
}
