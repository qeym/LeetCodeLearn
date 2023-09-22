package hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution347 {

    public static void main(String[] args) {
        int[] input = new int[]{1};
        new Solution347().topKFrequent(input, 1);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Arrays.sort(nums);

        int[] temp = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0){
                temp[0] = nums[0];
                temp[1] = 1;
                continue;
            }
            if(nums[i] == nums[i-1]){
                temp[1]++;
            }else{
                heap.add(new int[]{temp[0], temp[1]});
                temp[0] = nums[i];
                temp[1] = 1;
            }
        }
        heap.add(temp);

        for(int i = 0 ; i < ans.length && !heap.isEmpty() ; i++){
            ans[i] = heap.poll()[0];
        }
        return ans;

    }
}
