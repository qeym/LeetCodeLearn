package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public static void main(String[] args) {
        List<String> list = new Solution22().generateParenthesis(1);
        for(String cur:list){
            System.out.println(cur);
        }
    }

    List<String> ans;
    StringBuilder curStr;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        curStr = new StringBuilder();
        handle(0, 0, n);
        return ans;
    }

    public void handle(int leftBracketNum, int rightBracketNum,int n){
        if(leftBracketNum > n || rightBracketNum > n || leftBracketNum < rightBracketNum) return;

        if(leftBracketNum == rightBracketNum && leftBracketNum == n){
            ans.add(curStr.toString());
            return;
        }

        if(leftBracketNum < n){
            curStr.append("(");
            handle(leftBracketNum + 1 , rightBracketNum , n);
            curStr.deleteCharAt(curStr.length() - 1);
        }
        if(rightBracketNum < leftBracketNum && rightBracketNum < n){
            curStr.append(")");
            handle(leftBracketNum , rightBracketNum + 1, n);
            curStr.deleteCharAt(curStr.length() - 1);
        }

    }
}
