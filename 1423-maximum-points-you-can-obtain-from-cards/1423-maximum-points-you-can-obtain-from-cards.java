class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int lsum =0;
        int rsum = 0;
        int maxsum = 0;
        for(int i=0;i<k;i++) {
            lsum = lsum + nums[i];
        }
        maxsum = lsum;

        int rightidx = n-1;
        for(int i=k-1;i>=0;i--) {
            lsum = lsum - nums[i];
            rsum = rsum + nums[rightidx];
            rightidx--;

            maxsum = Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}