package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution148 {
    public static void main(String[] args) {
        ListNode listNode = new Solution148().sortList(null);
        listNode.print();
    }
    public ListNode sortList(ListNode head) {
        List<ListNode> nodeArrayList = new ArrayList<>();
        while (head != null){
            nodeArrayList.add(head);
            head = head.next;
        }
        Collections.sort(nodeArrayList, Comparator.comparingInt(n -> n.val));
        ListNode ans = new ListNode(0),curNode = ans;
        for(ListNode cur: nodeArrayList){
            curNode.next = cur;
            curNode = cur;
        }
        curNode.next = null;
        return ans.next;
    }
}
