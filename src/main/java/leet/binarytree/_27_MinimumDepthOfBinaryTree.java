package leet.binarytree;

import leet.ICodePoints;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树  最小高度
 *
 * The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 * Solution:
 *
 *解法1
 * O(n) runtime, O(log n) space – Depth-first traversal:
 * Similar to the [Recursion] approach to find the maximum depth,
 * but make sure you consider these cases:
 * i. The node itself is a leaf node. The minimum depth is one.
 * ii. Node that has one empty sub-tree while the other one is non-empty.
 * Return the minimum depth of that non-empty sub-tree.
 */

public class _27_MinimumDepthOfBinaryTree {

    @ICodePoints("解法1 Depth-first traversal|| O(n) runtime, O(log n) space")
    public int minimumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

//        @ICodePoints("如果一个节点有一个节点非空，那么最小长度是包含叶子节点的那个路径树")
        if (root.left == null) {
            return minimumDepth(root.right)+1;
        }
        if (root.right == null) {
            return minimumDepth(root.left)+1;
        }
        return Math.min(minimumDepth(root.left),minimumDepth(root.right))+1;
    }

    @ICodePoints("解法2 O(n) runtime, O(n) space – Breadth-first traversal:")
    /*
    [3,9,20,null,null,15,7]
    预期2 输出1
     */
    public int minimumDepth2(TreeNode root) {
        LinkedList<TreeNode> queue =new LinkedList<>();
        if(root==null) return 0;
        int level=1;
        TreeNode last = root;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.left == null && node.right == null) {
                break;
            }
            if(node.left!=null) queue.addLast(node.left);
            if(node.right!=null) queue.addLast(node.right);
            if (node == last) {
                level++;
                if (!queue.isEmpty()) {
                    last= queue.getLast();
                }
            }

        }
        return level;
    }

    /**
     * 输入:
     * [3,9,20,null,null,15,7]
     * 输出
     * [[3],[9,20]]
     * 预期结果
     * [[3],[9,20],[15,7]]

     */

    @ICodePoints("二叉树层序遍历")
    @ICodePoints("https://leetcode-cn.com/problems/binary-tree-level-order-traversal/")
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode>queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        TreeNode last = root;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node  = queue.removeFirst();
            list1.add(node.val);
            if(node.left!=null) queue.addLast(node.left);
            if(node.right!=null) queue.addLast(node.right);
//            @ICodePoints("确定时机，记录每一层最后一个节点")
            if(node == last ){
                result.add(list1);
//                @ICodePoints("只有在queue非空情况下才设置last节点")
                if (!queue.isEmpty()) {
                    list1 = new ArrayList<>();
                    last = queue.getLast();
                }
            }
        }
        return result;
    }

}
