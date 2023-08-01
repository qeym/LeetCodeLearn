package hot100;

public class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }

   ListNode(int[] arrary){
       ListNode cur = this;
       cur.val = arrary[0];
       for(int i = 1 ; i < arrary.length ; i++){
           cur.next = new ListNode(arrary[i]);
           cur = cur.next;
       }
   }

   public void print(){
       ListNode cur = this;
       while (cur != null){
           System.out.println(cur.val);
           cur = cur.next;
       }
   }
}
