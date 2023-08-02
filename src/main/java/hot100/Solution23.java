package hot100;

import java.util.*;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode ans = new ListNode(0), ansCur = ans;
        List<ListNode> curNodeList = new LinkedList<>();

        for(ListNode cur: lists){
            if(cur != null) curNodeList.add(cur);
        }

        Collections.sort(curNodeList, Comparator.comparingInt(o -> o.val));

        while (curNodeList.size() > 0){
            ansCur.next = curNodeList.get(0);
            ansCur = ansCur.next;
            curNodeList.remove(0);

            ListNode newNode = ansCur.next;
            if(newNode == null) continue;

            boolean insert = false;
            for(int i = 0 ; i < curNodeList.size() ; i++){
                if(curNodeList.get(i).val > newNode.val){
                    curNodeList.add(i, newNode);
                    insert = true;
                    break;
                }
            }
            if(!insert) curNodeList.add(newNode);


        }
        return ans.next;

    }
}
