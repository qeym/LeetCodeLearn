package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    public static void main(String[] args) {
        new Solution131().partition("abbabc");
    }

    List<List<String>> ans;
    List<String> cur;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();
        handle(s, 0 , 0);
        return ans;
    }

    public void handle(String s, int start ,int end){
        if(end >= s.length() || start > end) return;

        boolean reverse = isReverse(s, start, end);
        String curStr = s.substring(start, end + 1);

        if(end == s.length() - 1 && reverse){
            List<String> newAns = new ArrayList<>(cur);
            newAns.add(curStr);
            ans.add(newAns);
            return;
        }

        if(reverse){
            cur.add(curStr);
            handle(s, end+1, end+1);
            cur.remove(cur.size() - 1);
        }
        handle(s, start ,end +1);
    }

    public boolean isReverse(String s, int start, int end){
        while (start <= end && start < s.length() - 1 && end >= 0){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
