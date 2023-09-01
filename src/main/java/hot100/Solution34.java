package hot100;

public class Solution34 {

    public static void main(String[] args) {
        int[] input = new int[]{8,8,8,8,8,8};
        new Solution34().searchRange(input, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return ans;

        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = ( start + end )/2;
            if(nums[mid] == target){
                if(mid == 0){
                    ans[0] = mid;
                    break;
                }

                if(nums[mid-1] != target){
                    ans[0] = mid;
                    break;
                }
                end = mid - 1;

            }else if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }
        }

        start = ans[0] != - 1 ? ans[0] : 0;
        end = nums.length - 1;
        while (start <= end){
            int mid = ( start + end )/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1){
                    ans[1] = mid;
                    break;
                }

                if(nums[mid+1] != target){
                    ans[1] = mid;
                    break;
                }

                start = mid + 1;

            }else if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }
        }

        return ans;
    }



}
