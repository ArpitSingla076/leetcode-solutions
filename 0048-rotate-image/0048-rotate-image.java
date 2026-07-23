class Solution {
    // public void swap(int[][]matrix,int i,int j){
    //     int temp = matrix[i][j];
    //     matrix[i][j] = matrix[j][i];
    //     matrix[j][i] = temp;
    // }

    public void rotate(int[][] matrix) {
        // -- brute force --
        // int n = matrix.length;
        // int[][] ans = new int[n][n];
        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<n;j++) {
        //         ans[j][n-1-i]=matrix[i][j];
        //     }
        // }

        // // copy back to matrix
        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<n;j++) {
        //         matrix[i][j] = ans[i][j];
        //     }
        // }


        // -- optimal App (transpose+reverse each row) --
        int n = matrix.length;

        // transpose
        for(int i=0;i<=n-2;i++) {
            for(int j=i+1;j<=n-1;j++) {
               // swap(matrix,i,j);
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }

        // reverse each row
        for(int i=0;i<n;i++) {
            int st=0;
            int end=n-1;
            while(st<=end) {
                int temp = matrix[i][st];
                matrix[i][st] = matrix[i][end];
                matrix[i][end] = temp;
                st++;
                end--;
            }
        }
    }
}