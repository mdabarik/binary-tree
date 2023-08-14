/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) return preorder;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostChild = curr.left;
                while (rightMostChild.right != null && rightMostChild.right != curr) {
                    rightMostChild = rightMostChild.right;
                }
                if (rightMostChild.right == null) { // if we get null it's means we don't have thread
                    rightMostChild.right = curr; // create a thread
                    preorder.add(curr.val);
                    // Ro, L, R
                    curr = curr.left;
                } else { // if we have a thread from rightMostChild -> curr
                    rightMostChild.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}

// TC: O(n), SC: O(1)





















