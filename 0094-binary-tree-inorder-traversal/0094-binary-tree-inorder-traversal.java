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

// --- this is recursive sol --- 
// class Solution {
//     public void inorder(TreeNode root,List<Integer>ans) {
//         if(root==null)return;
//         inorder(root.left,ans);
//         ans.add(root.val);
//         inorder(root.right,ans);
//     }

//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer>ans = new ArrayList<>();
//         inorder(root,ans);
//         return ans;
//     }
// }


// -- this is iterative sol --(using stack)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);

            curr = curr.right;
        }
        return ans;
    }
}