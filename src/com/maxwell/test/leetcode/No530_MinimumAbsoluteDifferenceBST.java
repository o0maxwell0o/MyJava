package com.maxwell.test.leetcode;

public class No530_MinimumAbsoluteDifferenceBST {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    int last;
    int diff;

    public int getMinimumDifference(TreeNode root) {
        last = Integer.MAX_VALUE;
        diff = Integer.MAX_VALUE;
        find(root);
        return diff;
    }

    public void find(TreeNode node) {
        if (node == null)
            return;
        find(node.left);
        diff = Math.min(diff, Math.abs(last - node.val));
        last = node.val;
        find(node.right);

    }

}
