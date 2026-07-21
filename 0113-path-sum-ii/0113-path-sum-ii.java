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
    public void printPath(TreeNode root,int targetSum,List<Integer>path,List<List<Integer>>ans) {
        if(root==null) return;
        path.add(root.val);
        targetSum-=root.val;
        
        // leaf node
        if(root.left==null && root.right==null && targetSum==0) {
            ans.add(new ArrayList<>(path));
        }
        printPath(root.left,targetSum,path,ans);
        printPath(root.right,targetSum,path,ans);

        // backtrack step
        path.remove(path.size()-1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        printPath(root,targetSum,path,ans);
        return ans;
    }
}