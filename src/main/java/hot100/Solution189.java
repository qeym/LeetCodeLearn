package hot100;

public class Solution189 {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};
        new Solution189().rotate(input, 3);
        for(int cur:input){
            System.out.println(cur);
        }
    }
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            temp[(i+k)%nums.length] = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = temp[i];
        }
    }
}
