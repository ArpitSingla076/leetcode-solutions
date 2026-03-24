class Solution {
    public void helper(int[] nums,int i,List<Integer> sub,
    List<List<Integer>> ans,int target) {
        // base case
        if(target==0) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        if(i==nums.length || target<0) return;

        // kaam
        // take (same index -> reuse allowed) (single include in multiple include)
        sub.add(nums[i]);
        helper(nums,i,sub,ans,target-nums[i]);

        // backtracking step
        sub.remove(sub.size()-1); 

        // not taken
        helper(nums,i+1,sub,ans,target);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(nums,0,sub,ans,target);
        return ans;
    }
}

