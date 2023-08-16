/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        return dfs(root, p, q);
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (root.left == null && root.right == null) return null;
        // recursive case
        TreeNode leftLCA = dfs(root.left, p, q);
        TreeNode rightLCA = dfs(root.right, p, q);
        // if (leftLCA == null && rightLCA != null) {
        //     return rightLCA;
        // }
        // if (leftLCA != null && rightLCA == null) {
        //     return leftLCA;
        // }
        // if (leftLCA == null && rightLCA == null) {
        //     return null;
        // }
        if (leftLCA == null) return rightLCA;
        if (rightLCA == null) return leftLCA;
        return root;
    }
}
// TC: O(n), SC: O(n)
