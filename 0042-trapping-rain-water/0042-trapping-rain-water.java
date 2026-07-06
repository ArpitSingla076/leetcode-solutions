class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i=0;
        int j=n-1;
        int lmax=0;
        int rmax=0;
        int total=0;
        while(i<j) {
            lmax = Math.max(lmax,height[i]);
            rmax = Math.max(rmax,height[j]);
            if(lmax<rmax) {
                total+=lmax-height[i];
                i++;
            }
            else{
                total+=rmax-height[j];
                j--;
            }
        }
        return total;
    }
}