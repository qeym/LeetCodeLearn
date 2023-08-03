package hot100;

import hot100.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while (temp.size() > 0){
            int size = temp.size();
            List<Integer> curLayerNodes = new ArrayList<>();
            for(int i = 0 ; i < size ; i ++){
                TreeNode cur = temp.get(0);
                temp.remove(0);

                curLayerNodes.add(cur.val);
                if(cur.left != null) temp.add(cur.left);
                if(cur.right != null) temp.add(cur.right);
            }
            ans.add(curLayerNodes);
        }
        return ans;
    }
}
