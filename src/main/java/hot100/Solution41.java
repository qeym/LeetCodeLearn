package hot100;

import java.util.Arrays;

public class Solution41 {
    public static void main(String[] args) {
        int i = new Solution41().firstMissingPositive(new int[]{0,0,0});
        System.out.println(i);
    }
    public int firstMissingPositive(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= 0) nums[i] = nums.length +1;
        }

        for(int i = 0 ; i < nums.length ; i++){
            int temp = Math.abs(nums[i]);
            if(temp > 0 && temp <= nums.length && nums[temp - 1] > 0){
                nums[temp - 1] *= -1;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0) return i+1;
        }
        return nums.length + 1;

    }
}
