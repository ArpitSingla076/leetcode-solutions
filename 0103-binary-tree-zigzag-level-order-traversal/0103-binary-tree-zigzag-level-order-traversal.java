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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        if(root!=null)q.add(root);
        while(q.size()>0) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                 sub.add(curr.val);
                
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
            if(level%2==0) {
                Collections.reverse(sub);
            }
            level++;
            ans.add(sub);
        }
        return ans;
    }
}