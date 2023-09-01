package hot100;

public class Solution33 {
    public static void main(String[] args) {
        int[] input = new int[]{6,7,8,1,2,3,4,5};
        int search = new Solution33().search(input, 6);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {

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

        start = 0;
        end = nums.length - 1;
        while (start <= end){

            int mid = (start + end)/2;
            int transMid = ( mid + rotateKey + 1) % nums.length;
            if(nums[transMid] == target){
                return transMid;
            } else if (nums[transMid] < target) {
                start = mid + 1;
            } else if(nums[transMid] > target){
                end = mid - 1;
            }
        }
        return -1;
    }
}
