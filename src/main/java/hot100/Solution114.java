package hot100;

import hot100.tools.TreeNode;

public class Solution114 {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(new Integer[]{1,2,5,3,4,null,6});
        TreeNode.show(input);
        new Solution114().flatten(input);
        TreeNode.show(input);
    }

    public void flatten(TreeNode root) {
        handle(root);
    }

    public TreeNode handle(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        if(root.left == null){
            return handle(root.right);
        }else if(root.right == null){
            root.right = root.left;
            root.left = null;
            return handle(root.right);
        }

        TreeNode rightNode = root.right;
        TreeNode leftLastNode = handle(root.left);

        root.right = root.left;
        root.left = null;
        leftLastNode.right = rightNode;

        return handle(root.right);

    }
}
