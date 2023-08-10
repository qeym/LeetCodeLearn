package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    public static void main(String[] args) {
        new Solution39().combinationSum(new int[]{8},8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        curAns = new ArrayList<>();
        handle(candidates, target, 0);

        return ans;
    }

    List<List<Integer>> ans;
    List<Integer> curAns;


    public void handle(int[] candidates, int target, int index){
        if(index >= candidates.length) return;

        int curNum = candidates[index];
        if(curNum == target){

            List<Integer> newAns = new ArrayList<>(curAns);
            newAns.add(curNum);
            ans.add(newAns);

        }else if(curNum < target){


            curAns.add(curNum);
            handle(candidates, target - curNum, index);
            curAns.remove(curAns.size() - 1);

            handle(candidates, target, index + 1);

        }
    }
}
