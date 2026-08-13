class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int i=0;
        int j=0;
        while(i<m && j<n) {
            if(s[j]>=g[i]) {
                // can satisfy
                count++;
                i++;
                j++;
            }
            else{
                // cant satisfy 
                j++;
            }
        }
        return count;
    }
}