package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {

    public static void main(String[] args) {
        new Solution438().findAnagrams("abab", "ab");
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        String key = new String(charArray);

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i <= s.length() - p.length() ; i++){
            String cur = s.substring(i, i + p.length());
            if(isMatch(key, cur)){
                result.add(i);
            }
        }

        return result;

    }

    public boolean isMatch(String first, String second){
        char[] charArray = second.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray).equals(first);

    }
}
