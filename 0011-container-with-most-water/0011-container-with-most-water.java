class Solution {
    public int maxArea(int[] height) {
        // -- Brute force(find all possible container and check) --
        // int n = height.length;
        // int maxwater = 0;
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         int w = j-i;
        //         int h = Math.min(height[i],height[j]);
        //         int area = w*h;
        //         maxwater = Math.max(area,maxwater);
        //     }
        // }
        // return maxwater;

        // -- Optimal sol(using 2 pointer) --
        int n = height.length;
        int lp = 0;
        int rp = n-1;
        int maxwater = 0;
        while(lp<rp) {
            int w = rp-lp;
            int ht  = Math.min(height[lp],height[rp]);
            int currWater = w*ht;
            maxwater = Math.max(currWater,maxwater);
            if(height[lp]<height[rp]) {
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxwater;
    }
}