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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) return postorder;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            // Ro, R, L -- reverse preorder traversal
            while (curr != null) {
                postorder.add(curr.val);
                if (curr.left != null)
                    stack.push(curr.left);
                curr = curr.right;
            }
        }
        // L, R, Ro
        Collections.reverse(postorder);
        return postorder;
    }
}
// TC: O(n), SC: O(n)
