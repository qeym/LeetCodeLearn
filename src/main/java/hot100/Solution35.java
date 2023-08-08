package hot100;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return handle(nums, target, 0 ,nums.length -1 );
    }

    public int handle(int[] nums, int target, int begin, int end){

        int mid = (begin + end)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target){
            if(begin == mid) return begin != 0 ? begin-1 : 0;

            return handle(nums, target, begin, mid-1);
        }
        if(nums[mid] < target){
            if(end == mid) return end+1;
            return handle(nums, target, mid+1 , end);
        }
        return -1;
    }

}
