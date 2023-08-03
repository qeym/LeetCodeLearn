package hot100;

import hot100.tools.TreeNode;

public class Solution98 {

    public static void main(String[] args) {
        System.out.println(new Solution98().isValidBST(new TreeNode(new Integer[]{5,1,4,null,null,3,6})));
    }

    public boolean isValidBST(TreeNode root) {
        return vaild(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean vaild(TreeNode root, long max, long min){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return vaild(root.left, root.val, min) && vaild(root.right, max, root.val);

    }
}
