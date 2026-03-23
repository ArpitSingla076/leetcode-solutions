// --- Permutation using a visited array ---

// class Solution {
//     public void helper(int[]nums,List<Integer>sub,List<List<Integer>>ans,boolean[]isValid) {
//         if(sub.size()==nums.length) {
//             ans.add(new ArrayList<>(sub));
//             return;
//         }
//         for(int i=0;i<nums.length;i++) {
//             if(isValid[i]==false) { // call lagega
//                 sub.add(nums[i]);
//                 isValid[i] = true;
//                 helper(nums,sub,ans,isValid);
//                 isValid[i] = false; // backtrack
//                 sub.remove(sub.size()-1);
//             }
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         int n = nums.length;
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> sub = new ArrayList<>();
//         boolean[] isValid = new boolean[n];
//         helper(nums,sub,ans,isValid);
//         return ans;
//     }
// }


// -- Permutation without using a visited array (using idx variable) --

class Solution {
    public void swap(int i,int j,int[]nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void helper(int[]nums,int idx,List<List<Integer>>ans) {
        int n = nums.length;
        // base case
        if(idx==n-1) {
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++) {
                sub.add(nums[i]);
            }
            ans.add(sub);
            return;
        }
      
      // kaam
      for(int i=idx;i<n;i++) {
        swap(i,idx,nums);
        helper(nums,idx+1,ans);
        swap(i,idx,nums); // backtrack
      }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
}