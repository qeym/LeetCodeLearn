package hot100;

import hot100.tools.TreeNode;

import java.util.HashMap;

public class Solution236 {


    HashMap<TreeNode, TreeNode> fatherNodes = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findFather(root, p, q);

        TreeNode cur = p;
        HashMap<TreeNode, Boolean> temp = new HashMap<>();
        while (cur != null){
            temp.put(cur, true);
            cur = fatherNodes.get(cur);
        }
        cur = q;
        while (cur != null){
            if(temp.containsKey(cur)) return cur;
            cur = fatherNodes.get(cur);
        }
        return null;
    }

    public void findFather(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        if(fatherNodes.containsKey(p) && fatherNodes.containsKey(q)) return;
        if(root.left != null){
            fatherNodes.put(root.left, root);
            findFather(root.left, p, q);
        }
        if(root.right != null){
            fatherNodes.put(root.right, root);
            findFather(root.right, p, q);
        }
    }
}
