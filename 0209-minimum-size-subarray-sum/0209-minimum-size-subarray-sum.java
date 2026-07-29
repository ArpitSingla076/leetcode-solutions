class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l=0;
        int r=0;
        int minlen=Integer.MAX_VALUE;
        int sum=0;
        for(r=0;r<n;r++) {
            sum+=nums[r];
            while(sum>=target) {
                minlen = Math.min(minlen,r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return minlen == Integer.MAX_VALUE? 0:minlen;
    }
}