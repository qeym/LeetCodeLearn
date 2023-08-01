package hot100;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(pre > 0){
                pre += nums[i];
            }else pre = nums[i];
            if(pre > ans) ans = pre;
        }
        return ans;
    }
}
