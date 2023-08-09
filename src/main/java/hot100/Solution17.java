package hot100;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args) {
        new Solution17().letterCombinations("");
    }

    List<String> ans;
    StringBuilder sb;
    String[] temp;


    public List<String> letterCombinations(String digits) {
        temp = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans = new ArrayList<>();

        if(digits == null || digits.isEmpty()) return ans;
        sb = new StringBuilder();
        handle(digits, 0);
        return ans;
    }

    public void handle(String digits, int digIndex){
        int charIndex = digits.charAt(digIndex) - '0';
        String tempStr = temp[charIndex - 2];

        for(char cur: tempStr.toCharArray()){
            sb.append(cur);
            if(sb.length() == digits.length()){
                ans.add(sb.toString());
            }else{
                handle(digits, digIndex+1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
