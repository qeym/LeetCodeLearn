package hot100;

import hot100.tools.TreeNode;

public class Solution230 {
    int num;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        handle(root);
        return ans;
    }

    public void handle(TreeNode root){
        if(num <= 0) return;
        if(root == null) return;
        handle(root.left);
        num--;
        if(num == 0) ans = root.val;
        handle(root.right);
    }
}
