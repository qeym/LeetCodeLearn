package hot100;

import hot100.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution534 {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(new Integer[]{1,2,3,4,5});
        new Solution534().diameterOfBinaryTree(input);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        return handle(root).get(1);

    }

    public List<Integer> handle(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(0);
        if(root == null) return null;
        if(root.left == null && root.right == null) return ans;

        List<Integer> leftResult = handle(root.left);
        List<Integer> rightResult = handle(root.right);

        int maxDep = Math.max(leftResult != null ? leftResult.get(0) + 1 : 0,
                rightResult != null ? rightResult.get(0) + 1 : 0) ;
        ans.set(0, maxDep);

        int maxRoad = Math.max(
                Math.max(leftResult != null ? leftResult.get(1) : 0,
                        rightResult != null ? rightResult.get(1) : 0),
                (leftResult != null ? leftResult.get(0) + 1 : 0) +
                        (rightResult != null ? rightResult.get(0) + 1 : 0));
        ans.set(1, maxRoad);
        return ans;
    }
}
