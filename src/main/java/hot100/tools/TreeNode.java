package hot100.tools;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

    public TreeNode(Integer[] input){
        this(getTreeNode(input).val, getTreeNode(input).left, getTreeNode(input).right);
    }

    public static TreeNode getTreeNode(Integer[] input){
        TreeNode[] nodes = new TreeNode[input.length];
        for(int i = 0 ; i < input.length ; i++){
            if(input[i] != null)
                nodes[i] = new TreeNode(input[i]);
        }
        for(int i = 0 ; i < nodes.length/2 ; i++){
            if(nodes[i] == null) continue;
            if(nodes[i*2] != null) nodes[i].left = nodes[i*2];
            if(nodes[i*2+1] != null) nodes[i].right = nodes[i*2+1];
        }
        return nodes[0];
    }
 }
