package hot100;

import hot100.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        if(root.left != null) ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        if(root.right != null) ans.addAll(inorderTraversal(root.right));

        return ans;
    }
}
