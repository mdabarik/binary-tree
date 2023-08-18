class Solution { 
    static int largestBst(Node root) {
        // Left, Right, Root
        int[] result = postOrder(root); // [min, max, size]
        return result[2];
    }
    static int[] postOrder(Node root) {
        // base case
        if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        if (root.left == null && root.right == null) // for leaf node
            return new int[] {root.data, root.data, 1};
        // recursive case
        int[] leftInfo = postOrder(root.left);
        int[] rightInfo = postOrder(root.right);
        // if our current subtree is a valid bst
        if (leftInfo[1] < root.data && root.data < rightInfo[0]) {
            int sizeOfBST = 1 + leftInfo[2] + rightInfo[2];
            return new int[] {Math.min(root.data, leftInfo[0]), Math.max(root.data, rightInfo[1]), sizeOfBST};
        } else { // if our current subtree is not a valid bst
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftInfo[2], rightInfo[2])};
        }
    }
}
// TC: O(n), SC: O(n)
