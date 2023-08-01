package hot100;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> tempSet = new HashSet<>();
        for(int cur: nums){
            tempSet.add(cur);
        }

        int result = 1;
        for(int cur:tempSet){
            if(tempSet.contains(cur - 1)) continue;

            int count = 1;
            int curNum = cur + 1;
            while(tempSet.contains(curNum)){
                count++;
                curNum++;
            }
            if(count > result) result = count;
        }

        return result;
    }
}
