package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        new Solution49().groupAnagrams(strs);
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> tempMap = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            List<String> stringList = tempMap.getOrDefault(key, new ArrayList<>());
            stringList.add(str);
            tempMap.put(key, stringList);
        }
        return new ArrayList<>(tempMap.values());
    }


}
