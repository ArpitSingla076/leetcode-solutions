// class Solution {
//     public void helper(int[] nums,int i,List<Integer> sub,
//     List<List<Integer>> ans,int target) {
//         // base case
//         if(target==0) {
//             ans.add(new ArrayList<>(sub));
//             return;
//         }

//         if(i==nums.length || target<0) return;

//         // kaam
//         // take (same index -> reuse allowed) (single include in multiple include)
//         sub.add(nums[i]);
//         helper(nums,i,sub,ans,target-nums[i]);

//         // backtracking step
//         sub.remove(sub.size()-1); 

//         // not taken
//         helper(nums,i+1,sub,ans,target);
//     }

//     public List<List<Integer>> combinationSum(int[] nums, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> sub = new ArrayList<>();
//         helper(nums,0,sub,ans,target);
//         return ans;
//     }
// }


// ------- Use set for unique combinations ----------------

class Solution {

    Set<List<Integer>> set = new HashSet<>();

    public void helper(int[] nums, int idx, int target,
            List<Integer> sub, List<List<Integer>> ans) {

        // base case
        if (idx == nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            if (!set.contains(sub)) {
                ans.add(new ArrayList<>(sub));
                set.add(new ArrayList<>(sub));
            }
            return;
        }

        // include current element
        sub.add(nums[idx]);

        // Single include
        helper(nums, idx + 1, target - nums[idx], sub, ans);

        // Multiple include
        helper(nums, idx, target - nums[idx], sub, ans);

        // Backtrack
        sub.remove(sub.size() - 1);

        // Exclude current element
        helper(nums, idx + 1, target, sub, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        helper(candidates, 0, target, sub, ans);

        return ans;
    }
}