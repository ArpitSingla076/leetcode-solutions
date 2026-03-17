class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int len = 0;
        int maxlen = 0;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) {
                len++;
                maxlen = Math.max(len,maxlen);
            }
            else{
                len=0;
            }
        }
        return maxlen;
    }
}