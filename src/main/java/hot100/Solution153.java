package hot100;

public class Solution153 {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length  - 1;
        int rotateKey = -1;
        while (start <= end){
            if(nums[start] < nums[end]){
                break;
            }

            int mid = (start + end )/2;
            if(mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]){
                rotateKey = mid;
                break;
            }
            if(mid - 1 > 0 && nums[mid] < nums[mid - 1]){
                rotateKey = mid-1;
                break;
            }

            if(nums[mid] > nums[start]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        int index = (rotateKey + 1)% nums.length;
        return nums[index];
    }
}
