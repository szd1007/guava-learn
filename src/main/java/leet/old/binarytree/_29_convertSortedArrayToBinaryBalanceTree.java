package leet.old.binarytree;

import leet.ICodePoints;

public class _29_convertSortedArrayToBinaryBalanceTree {

    @ICodePoints("O(n) runtime, O(log n) stack space – Divide and conquer:")
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, s, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, e);
        return node;
    }
}
