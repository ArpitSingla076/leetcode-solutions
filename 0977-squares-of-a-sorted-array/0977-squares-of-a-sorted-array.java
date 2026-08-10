class Solution {
    public int[] sortedSquares(int[] nums) {
        // -- brute force --
        // int n = nums.length;
        // for(int i=0;i<n;i++) {
        //     nums[i] = nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        // --- optimal ---
        int n = nums.length;
        int i=0;
        int j=n-1;
        int k=n-1;
        int[] ans = new int[n];
        while(i<=j) {
            if(Math.abs(nums[i])>Math.abs(nums[j])) {
                ans[k] = nums[i]*nums[i];
                i++;
                k--;
            }
            else{
                ans[k] = nums[j]*nums[j];
                j--;
                k--;
            }
        }
        return ans;
    }
}