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

        // skipping the duplicates values 
        int idx = i+1;
        while(idx<nums.length && nums[idx]==nums[idx-1]) idx++;

        // No choice
        helper(nums,sub,ans,idx);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(nums,sub,ans,0);
        return ans;   
    }
}