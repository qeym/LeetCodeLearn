package hot100;

import hot100.tools.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(head.next == null) return new Node(head.val);
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;

            cur = newNode.next;
        }

        cur = head;
        while (cur != null){
            Node next = cur.next;
            if(cur.random != null){
                next.random = cur.random.next;
            }
            cur = next.next;
        }

        cur = head;
        Node ans = cur.next, returnAns = ans;
        while (cur != null){
            cur.next = ans.next;
            if(cur.next != null)
            ans.next = cur.next.next;

            cur = cur.next;
            ans = ans.next;

        }
        return returnAns;
    }
}
