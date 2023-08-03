package hot100;

import hot100.tools.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return handle(nums, 0 , nums.length - 1);
    }

    public TreeNode handle(int[] nums, int begin, int end){
        if(begin == end) return new TreeNode(nums[begin]);
        int mid = (begin + end)/2;
        TreeNode ans = new TreeNode(nums[mid]);
        if(mid > begin){
            ans.left = handle(nums, begin, mid-1);
        }
        if(mid < end){
            ans.right = handle(nums, mid+1, end);
        }
        return ans;

    }
}
