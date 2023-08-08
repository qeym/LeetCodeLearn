package hot100;

import hot100.tools.TreeNode;

public class Solution124 {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(new Integer[]{1,2,3});
        int i = new Solution124().maxPathSum(input);
        System.out.println(i);
    }

    long sum = Long.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        handle(root);
        return (int)sum;

    }

    public int handle(TreeNode root){
        if(root == null) return 0;


        int leftVal = Math.max(handle(root.left), 0);
        int rightVal = Math.max(handle(root.right), 0);

        int curVal = leftVal + rightVal + root.val;
        if(curVal > sum) sum = curVal;
        return root.val + Math.max(leftVal, rightVal);
    }

}
