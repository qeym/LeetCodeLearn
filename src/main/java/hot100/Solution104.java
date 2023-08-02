package hot100;

import hot100.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> nodeList = new ArrayList<>();

        nodeList.add(root);
        int dep = 1;
        while (nodeList.size() > 0){

            int size = nodeList.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode cur = nodeList.get(0);
                if(cur.left != null){
                    nodeList.add(cur.left);
                }
                if(cur.right != null){
                    nodeList.add(cur.right);
                }
                nodeList.remove(0);
            }
            dep++;

        }
        return dep;
    }
}
