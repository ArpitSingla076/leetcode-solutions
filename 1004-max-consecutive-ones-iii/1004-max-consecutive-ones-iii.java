class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l=0;
        int r=0;
        int maxlen=0;
        int cntzeros=0;
        for(r=0;r<n;r++) {
            if(nums[r]==0) {
                cntzeros++;
            }
            while(cntzeros>k) {
                if(nums[l]==0) {
                    cntzeros--;
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}