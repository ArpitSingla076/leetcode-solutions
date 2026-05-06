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
    public int height(TreeNode root) {
        if(root==null)return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);

        // if diameter pass through root
        int dia = lh+rh;

        return Math.max(dia,Math.max(ldia,rdia));
    }
}
