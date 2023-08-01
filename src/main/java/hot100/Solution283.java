package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution283 {
    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,3,12};
        new Solution283().moveZeroes(input);
        for(int i:input){
            System.out.println(i);
        }
    }

    public void moveZeroes(int[] nums) {

        List<Integer> nullIndexList = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++ ){
            if(nums[i] == 0){
                nullIndexList.add(i);
            }else{
                if(nullIndexList.size() != 0){
                    int curIndex = nullIndexList.get(0);
                    nums[curIndex] = nums[i];
                    nums[i] = 0;
                    nullIndexList.remove(0);
                    nullIndexList.add(i);
                }

            }
        }

    }
}
