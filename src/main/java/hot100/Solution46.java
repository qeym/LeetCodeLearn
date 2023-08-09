package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {

    public static void main(String[] args) {
        new Solution46().permute(new int[]{1,2,3,4,5});
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        handle(nums, new ArrayList<>());
        return ans;
    }

    List<List<Integer>> ans;

    public void handle(int[] nums, List<Integer> cur){

        for(int i = 0 ; i < nums.length ; i++){
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                if(cur.size() == nums.length){
                    ans.add(new ArrayList<>(cur));
                }else{
                    handle(nums, cur);
                }
                cur.remove(cur.size() - 1);
            }
        }
    }

}
