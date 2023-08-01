package hot100;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            ans[i] = nums[i] * ans[i-1];
        }

        int rightSum = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            ans[i] = rightSum * ans[i];
            rightSum *= nums[i];
        }

        return ans;
    }
}
