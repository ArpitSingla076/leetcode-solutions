class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = (1<<n);
        for(int i=0;i<subsets;i++) {
            List<Integer>sub = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i>>j)%2==1) {
                    sub.add(nums[j]);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}