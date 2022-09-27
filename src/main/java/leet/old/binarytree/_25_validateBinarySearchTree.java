package leet.old.binarytree;

/**
 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
 * 中序遍历，严格递增的有序队列
 */

public class _25_validateBinarySearchTree {



    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            return isValidBST(root.right);
        }
        return false;
    }
}
