class Solution {
    public int diagonalSum(int[][] mat) {
        // --- Brute force ---
        // int n = mat.length;
        // int sum=0;
        // for(int i=0;i<mat.length;i++) {
        //     for(int j=0;j<n;j++) {
        //         if(i==j) sum+=mat[i][j];
        //         if(i+j==n-1 && i!=j) {
        //             sum+=mat[i][j];
        //         }
        //     }
        // }
        // return sum;


        // -- Optimal App --
        int n = mat.length;
        int sum = 0;

        for (int i=0;i<n;i++) {
            // Primary diagonal
            sum += mat[i][i];

            // Secondary diagonal
            if (i!=n-1-i) {
                sum += mat[i][n-1-i];
            }
        }
        return sum;
    }
}