package leet.old.binarytree;

/**
 *    _____Node____
 *     /        \
 *    /          \
 * left subtree   right subtree
 *
 * Try the bottom up approach. At each node, the potential maximum path could be one of these cases:
 * i.    max(left subtree) + node
 * ii.   max(right subtree) + node
 * iii.  max(left subtree) + max(right subtree) + node
 * iv. the node itself
 *
 */

public class _31_binaryTreeMaxPath {
}
