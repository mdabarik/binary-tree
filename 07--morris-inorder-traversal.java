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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) return inorder;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) { // L, Ro, R
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left; // rightMostNode
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) { // we have to create a thread
                    predecessor.right = curr;
                    curr = curr.left;
                } else { // we have a tread
                    predecessor.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}
// TC: O(n), SC: O(1)
