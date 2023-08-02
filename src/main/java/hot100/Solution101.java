package hot100;

import hot100.tools.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return handle(root.left , root.right);
    }
    public boolean handle(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;

        return handle(left.left, right.right) && handle(left.right, right.left);

    }
}
