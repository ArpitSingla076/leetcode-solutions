class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum=0;
        int left=0;
        for(int val : nums) {
            sum+=val;
        }
        for(int i=0;i<n;i++) {
            int right = sum-nums[i]-left;
            if(left==right)return i;
            left+=nums[i];
        }
        return -1;
    }
}