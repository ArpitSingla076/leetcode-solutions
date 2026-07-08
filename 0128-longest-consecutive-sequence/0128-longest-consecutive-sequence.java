class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int len = 1;
        int maxlen=1;
        for(int i=0;i<n-1;i++) {
            if(nums[i]+1==nums[i+1]) {
                len++;
                maxlen = Math.max(len,maxlen);
            }
            else if(nums[i]==nums[i+1]) continue;
            else if(nums[i]<nums[i+1]) {
                len = 1;
            }
        }
        return maxlen;
    }
}