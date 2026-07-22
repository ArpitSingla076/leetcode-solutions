class Solution {
    public void swap(int[]nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        // -- Brute force --
        // int n = nums.length;
        // int cnt0=0;
        // int cnt1=0;
        // int cnt2=0;
        // for(int val : nums) {
        //     if(val==0) cnt0++;
        //     if(val==1) cnt1++;
        //     if(val==2) cnt2++;
        // }
        // int idx=0;
        // for(int i=0;i<cnt0;i++) {
        //     nums[idx++] = 0;
        // }
        // for(int i=0;i<cnt1;i++) {
        //     nums[idx++] = 1;
        // }
        // for(int i=0;i<cnt2;i++) {
        //     nums[idx++] = 2;
        // }


        // -- Dutch Flag Algo --
        int n = nums.length;
        int low = 0; 
        int mid = 0;
        int high = n-1;
        while(mid<=high) {
            if(nums[mid]==0) {
                swap(nums,mid,low);
                low++;
                mid++;
            }
            else if(nums[mid]==1)mid++;
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
}