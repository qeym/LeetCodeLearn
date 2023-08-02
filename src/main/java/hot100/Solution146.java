package hot100;

import java.util.HashMap;

public class Solution146 {

    public static void main(String[] args) {
        Solution146 lRUCache = new Solution146(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }

    class DoublyLinkedNode{
        public int key;
        public int value;
        public DoublyLinkedNode last;
        public DoublyLinkedNode next;

        public DoublyLinkedNode(){}
        public DoublyLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    DoublyLinkedNode head;
    DoublyLinkedNode rear;
    HashMap<Integer, DoublyLinkedNode> keyMap;

    public Solution146(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>(capacity);
        head = new DoublyLinkedNode();
        rear = head;
    }

    public int get(int key) {
        if(!keyMap.containsKey(key)){
            return -1;
        }

        DoublyLinkedNode cur = keyMap.get(key);

        reSort(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if(keyMap.containsKey(key)){
            DoublyLinkedNode cur = keyMap.get(key);
            cur.value = value;

            reSort(cur);
        }else{
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            keyMap.put(key, newNode);
            rear.next = newNode;
            newNode.last = rear;
            rear = newNode;

            if(capacity < keyMap.size()){
                keyMap.remove(head.next.key);
                head.next = head.next.next;
                head.next.last = head;
            }
        }
    }

    public void reSort(DoublyLinkedNode cur){
        DoublyLinkedNode last = cur.last, next = cur.next;

        if(cur == rear) return;
        last.next = next;
        next.last = last;

        rear.next = cur;
        cur.last = rear;
        cur.next = null;
        rear = cur;
    }
}
