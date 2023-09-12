package hot100;

import java.util.Stack;

public class Solution394 {

    public static void main(String[] args) {
        String s = new Solution394().decodeString("mn3[abc2[pq]ui]xy");
        System.out.println(s);
    }

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();

        Stack<String> stack = new Stack<>();

        for(char cur: s.toCharArray()){
            if((cur >= 'a' && cur <= 'z')||(cur >= '0' && cur <= '9') || cur == '['){
                stack.push(cur + "");
            }
            if(cur == ']'){
                StringBuilder cycleStr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")){
                    String popStr = stack.pop();
                    cycleStr.insert(0, popStr);
                }
                if(stack.peek().equals("[")) stack.pop();
                StringBuilder cycleTime = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    String popStr = stack.pop();
                    cycleTime.insert(0, popStr);
                }
                int cycleInt = Integer.parseInt(cycleTime.toString());
                StringBuilder pushStr = new StringBuilder();
                for(int i = 0 ; i < cycleInt ; i++){
                    pushStr.append(cycleStr);
                }
                stack.push(pushStr.toString());
            }

        }
        while (!stack.isEmpty()){
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

}
