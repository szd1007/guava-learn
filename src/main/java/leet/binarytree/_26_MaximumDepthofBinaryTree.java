package leet.binarytree;

/**
 * O(n) runtime, O(log n) space – Recursion:
 */
public class _26_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
