class Solution {
    public int[] productExceptSelf(int[] nums) {
        // -- Brute force(nested loops) --
        // int n = nums.length;
        // int[]ans = new int[n];
        // for(int i=0;i<n;i++) {  // pick element
        //     int prod = 1;
        //     for(int j=0;j<n;j++) {  // check all elements
        //         if(i!=j) {
        //             prod*=nums[j];
        //         }
        //     }
        //     ans[i] = prod;
        // }
        // return ans;

        // --Better App --
        // int n = nums.length;
        // int[] ans = new int[n];
        // int[] prefix = new int[n];
        // int[] suffix = new int[n];

        // // prefix
        // prefix[0] = 1;
        // for(int i=1;i<n;i++) {
        //     prefix[i] = prefix[i-1]*nums[i-1];
        // }

        // // suffix
        // suffix[n-1] = 1;
        // for(int i=n-2;i>=0;i--) {
        //     suffix[i] = suffix[i+1]*nums[i+1];
        // }

        // for(int i=0;i<n;i++) {
        //     ans[i] = prefix[i] * suffix[i];
        // }
        // return ans;

        // -- Optimal sol(with const space and linear time) --
         
        int n = nums.length;
        int ans[] = new int[n];

        // Prefix Products
        ans[0] = 1;
        for (int i=1;i<n;i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        //  Suffix Products 
        int suffix = 1;  
        for (int i=n-1;i>=0;i--) {
            ans[i] = ans[i] * suffix;  
            suffix *= nums[i];  
        }
        return ans;
    }
}