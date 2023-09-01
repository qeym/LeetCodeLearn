package hot100;

import java.util.Queue;
import java.util.Stack;

public class Solution20 {

    public static void main(String[] args) {
        boolean valid = new Solution20().isValid("()");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for(char cur: s.toCharArray()){
            if(cur == '(' || cur == '{' || cur == '['){
                charStack.push(cur);
            }
            if((cur == ')' && (charStack.isEmpty() || charStack.pop() != '(')) ||
                    (cur == ']' && (charStack.isEmpty() || charStack.pop() != '[')) ||
                    (cur == '}' && (charStack.isEmpty() || charStack.pop() != '{'))){
                return false;
            }
        }
        if(!charStack.isEmpty()) return false;
        return true;
    }
}
