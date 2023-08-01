package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution560 {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,1,2,1};
        int i = new Solution560().subarraySum(input, 3);
        System.out.println(i);
    }
    public int subarraySum(int[] nums, int k) {
        int result = 0 ;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0 ;
        sumMap.put(0, 1);
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) +1);

            if(sumMap.containsKey(sum - k)){
                result += sumMap.get(sum - k);
            }
        }

        return result;
    }
}
