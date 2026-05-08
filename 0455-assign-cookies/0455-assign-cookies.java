class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int i=0;
        int j=0;
        while(i<m && j<n) {
            if(s[j]>=g[i]) {
                i++;
                j++;
                count++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}