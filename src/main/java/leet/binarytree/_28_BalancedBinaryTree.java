package leet.binarytree;

import leet.ICodePoints;

/**
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树
 */
public class _28_BalancedBinaryTree {

    @ICodePoints("暴力破解  时间o(n*n)  空间o(n)")
    public boolean isBalanced(TreeNode root){
        if(root ==null)
            return true;
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    @ICodePoints("O(n) runtime, O(n) stack space – Bottom-up recursion:")

    public boolean isBalanced22(TreeNode root){
        return  maxDepth22(root)!=-1;
    }

    private int maxDepth22(TreeNode root) {
        if(root==null)
            return 0;
        int L = maxDepth22(root.left);
        if(L==-1)return -1;
        int R = maxDepth22(root.right);
        if(R==-1)return -1;
        return Math.abs(L - R) <= 1 ? Math.max(L, R) + 1 : -1;
    }

}
