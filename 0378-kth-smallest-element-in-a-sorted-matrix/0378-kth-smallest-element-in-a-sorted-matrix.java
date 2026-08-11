// -- brute force --
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] ans = new int[n*n];
        int idx=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ans[idx++] = matrix[i][j];
            }
        }
        Arrays.sort(ans);
        return ans[k-1];
    }
}