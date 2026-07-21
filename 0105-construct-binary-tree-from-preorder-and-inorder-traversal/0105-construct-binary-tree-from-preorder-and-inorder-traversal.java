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
    public TreeNode helper(int[]preorder,int pl,int ph,int[]inorder,int il,int ih) {
        if(pl>ph) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int i=il;
        while(preorder[pl]!=inorder[i]) i++;
        int leftsize = i-il;
        
        root.left = helper(preorder,pl+1,pl+leftsize,inorder,il,i-1);
        root.right = helper(preorder,pl+leftsize+1,ph,inorder,i+1,ih);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}