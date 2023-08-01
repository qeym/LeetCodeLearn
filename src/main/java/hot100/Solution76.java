package hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public static void main(String[] args) {
        String s = new Solution76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tRecord = new HashMap<>();
        for(char cur: t.toCharArray()){
            tRecord.put(cur, tRecord.getOrDefault(cur, 0) + 1);
        }
        int differ = t.length();
        Map<Character, Integer> sRecord = new HashMap<>();
        int i = 0, j = -1;

        String ans = "";
        char[] sArray = s.toCharArray();
        while(i < s.length()){
            //右扩
            while(differ > 0){
                j++;
                if(j >= s.length()) return ans;
                if(tRecord.containsKey(sArray[j])){
                    int charNum = sRecord.getOrDefault(sArray[j], 0);
                    if(charNum < tRecord.get(sArray[j])){
                        differ--;
                    }
                    sRecord.put(sArray[j], charNum + 1);
                }
            }
            //左缩
            while(true){
                if(i > j || i > s.length()) break;
                if(tRecord.containsKey(sArray[i])){
                    int charNum = sRecord.getOrDefault(sArray[i], 0);

                    if(charNum  <= tRecord.get(sArray[i])){
                        if(differ == 0 && (ans == null || j-i+1 < ans.length())){
                            ans = s.substring(i, j+1);
                            if(ans.length() == t.length()) return ans;
                        }
                        if(differ > 0){
                            break;
                        }
                        differ++;
                    }
                    sRecord.put(sArray[i], charNum-1);
                }
                i++;
            }
        }
        return ans;

    }
}
