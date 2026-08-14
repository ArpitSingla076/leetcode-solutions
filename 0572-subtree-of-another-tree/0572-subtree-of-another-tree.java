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
    public boolean SameTree(TreeNode p,TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return SameTree(p.left,q.left) && SameTree(p.right,q.right);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        // first check val
        if(root.val==subRoot.val) {
            // if val matches,check complete tree
            if(SameTree(root,subRoot)) {
                return true;
            }
        }
        // search in left and right
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}

