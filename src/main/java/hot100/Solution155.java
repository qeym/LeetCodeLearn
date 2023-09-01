package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution155 {

    List<Integer> temp = new ArrayList<>();
    List<Integer> minNum = new ArrayList<>();

    public Solution155(){
        minNum.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        temp.add(val);
        minNum.add(Math.min(minNum.get(minNum.size() - 1), val));
    }

    public void pop() {
        temp.remove(temp.size() - 1);
        minNum.remove(minNum.size() - 1);
    }

    public int top() {
        return temp.get(temp.size() - 1);
    }

    public int getMin() {
        return minNum.get(minNum.size() - 1);
    }
}
