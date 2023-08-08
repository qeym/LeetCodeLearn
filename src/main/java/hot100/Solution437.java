package hot100;

import hot100.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution437 {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000});
        TreeNode.show(input);
        int ans = new Solution437().pathSum(input, 0);
        System.out.println(ans);
    }

    public int pathSum(TreeNode root, int targetSum) {
        return handle(root, targetSum, null);
    }

    public int handle(TreeNode root, int targetSum, long[] curSum){
        int ans = 0, curSumLen;
        if(root == null) return ans;
        if(curSum == null) curSumLen = 0;
        else curSumLen = curSum.length;


        long[] newCurSum = new long[curSumLen + 1];

        for(int i = 0 ; i < curSumLen; i++){
            long roadLen = curSum[i] + root.val;
            if(roadLen == targetSum) {
                ans++;
            }
            newCurSum[i] = roadLen;
        }
        if(root.val == targetSum) ans++;
        newCurSum[newCurSum.length-1] = root.val;

        int leftMatchNum = handle(root.left, targetSum, newCurSum);
        int rightMatchNum = handle(root.right, targetSum, newCurSum);

        return ans + leftMatchNum + rightMatchNum;

    }
}
