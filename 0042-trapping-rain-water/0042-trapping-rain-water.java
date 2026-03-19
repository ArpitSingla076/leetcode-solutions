class Solution {
    public int trap(int[] height) {
        // -- Brute force (Using nested loops) --
        // int n = height.length;
        // int total = 0;

        // for(int i=0;i<n;i++) {
        //     int lmax = height[i];
        //     for(int j=0;j<=i;j++) {
        //         lmax = Math.max(lmax, height[j]);
        //     }

        //     int rmax = height[i];
        //     for (int j=i;j<n;j++) {
        //         rmax = Math.max(rmax, height[j]);
        //     }
        //     total += Math.min(lmax, rmax) - height[i];
        // }
        // return total;


        // -- Optimal sol(using Prefix Array) --
        // int n = height.length;
        // int[] lmax = new int[n];
        // int[] rmax = new int[n];
        // int ans = 0;
        // lmax[0] = height[0];
        // rmax[n-1] = height[n-1];
        // for(int i=1;i<n;i++) {
        //     lmax[i] = Math.max(lmax[i-1],height[i]);
        // }
        // for(int i=n-2;i>=0;i--) {
        //     rmax[i] = Math.max(rmax[i+1],height[i]);
        // }
        // for(int i=0;i<n;i++) {
        //     ans+= Math.min(lmax[i],rmax[i]) - height[i];
        // }
        // return ans;


        // ---Optimal Sol(using 2 Pointer) ---
        int n = height.length;
        int left = 0;
        int right = n-1;
        int lmax=0;
        int rmax=0;
        int ans=0;
        while(left<right) {
            lmax = Math.max(lmax,height[left]);
            rmax = Math.max(rmax,height[right]);
            if(lmax<rmax) { // lmax will decide how much water will store
                ans+=(lmax-height[left]);
                left++;
            }
            else{ // rmax will decide how much water will store
                ans+=(rmax-height[right]);
                right--;
            }
        }
        return ans;
    }
}