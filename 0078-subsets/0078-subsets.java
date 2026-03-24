class Solution {
    public void helper(int[]nums,List<Integer>sub,List<List<Integer>>ans,int i) {
        // base case
        if(i==nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        // kaam
        // Yes choice
        sub.add(nums[i]);
        helper(nums,sub,ans,i+1);

        // backtrack
        sub.remove(sub.size()-1);

        // No choice
        helper(nums,sub,ans,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,new ArrayList<>(),ans,0);
        return ans;
    }
}