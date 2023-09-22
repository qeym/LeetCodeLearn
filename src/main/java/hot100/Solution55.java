package hot100;

public class Solution55 {
    public static void main(String[] args) {
        int[] input = new int[]{3,0,8,2,0,0,1};
        new Solution55().canJump(input);
    }
    public boolean canJump(int[] nums) {
        int curIndex = 0;
        int maxIndex = 0;

        while (curIndex < nums.length - 1 && curIndex <= maxIndex){
            if(curIndex + nums[curIndex] > maxIndex){
                maxIndex = curIndex + nums[curIndex];
            }
            if(maxIndex >= nums.length - 1) return true;
            curIndex ++;
        }
        return false;

    }
}
