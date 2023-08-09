package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public static void main(String[] args) {
        new Solution78().subsets(new int[]{-1,2,4});
    }
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int allNum = (int)Math.pow(2,len);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < allNum ; i++){
            ans.add(intToBinary(nums, i));
        }
        return ans;
    }

    public List<Integer> intToBinary(int[] nums, int index){
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        while (index > 0 && i < nums.length){
            if(index%2 ==1 ){
                ans.add(nums[i]);
            }
            index = index/2;
            i++;
        }
        return ans;

    }
}
