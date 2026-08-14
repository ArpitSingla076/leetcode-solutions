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


// --- this is recursive sol --
// class Solution {
//     public void helper(TreeNode root,List<Integer> result) {
//         if(root==null)return;
//         helper(root.left,result);
//         helper(root.right,result);
//         result.add(root.val);

//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         helper(root,result);
//         return result;
//     }
// }


// --- this is iterstive(using stack) ---
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        if(root==null) return ans;
        st.push(root);
        while(st.size()>0) {
            TreeNode curr = st.pop();
            ans.add(curr.val);

            if(curr.left!=null) st.push(curr.left);
            if(curr.right!=null) st.push(curr.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}