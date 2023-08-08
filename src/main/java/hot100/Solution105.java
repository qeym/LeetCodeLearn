package hot100;

import hot100.tools.TreeNode;

//从前序与中序遍历序列构造二叉树
public class Solution105 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution105().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeNode.show(treeNode);

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return handle(inorder, 0, preorder.length -1 , preorder, 0 , inorder.length - 1);
    }

    public TreeNode handle(int[] preorder, int pBegin, int pEnd, int[] inorder, int oBegin, int oEnd){
        if(pBegin > pEnd) return null;
        if(pBegin == pEnd) return new TreeNode(preorder[pBegin]);

        int leftPBegin = pBegin,leftPEnd, leftOBegin = oBegin + 1,leftOEnd;
        int rightPBegin,rightPEnd = pEnd, rightOBegin, rightOEnd = oEnd;

        int rootIndex = -1;
        for(int i = pBegin ; i <= pEnd ; i++ ){
            if(preorder[i] == inorder[oBegin]){
                rootIndex = i;
                break;
            }
        }
        int leftLen = rootIndex - pBegin;
        int rightLen = pEnd - rootIndex;

        leftPEnd = leftPBegin + leftLen - 1;
        leftOEnd = leftOBegin + leftLen - 1;
        rightPBegin = rightPEnd - rightLen + 1;
        rightOBegin = rightOEnd -  rightLen + 1;

        TreeNode ans = new TreeNode(inorder[oBegin]);
        ans.left = handle(preorder, leftPBegin, leftPEnd, inorder, leftOBegin, leftOEnd);
        ans.right = handle(preorder, rightPBegin, rightPEnd, inorder, rightOBegin, rightOEnd);
        return ans;
    }
}
