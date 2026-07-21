class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer>ans = new ArrayList<>();
        int sr=0;
        int er=m-1;
        int sc=0;
        int ec=n-1;
        while(sr<=er && sc<=ec) {
            // print sr
            for(int j=sc;j<=ec;j++) {
                ans.add(matrix[sr][j]);
            }
            // print ec
            for(int i=sr+1;i<=er;i++) {
                ans.add(matrix[i][ec]);
            }
            // print er
            if(sr<er) {
                for(int j=ec-1;j>=sc;j--) {
                    ans.add(matrix[er][j]);
                }
            }
            // print sc
            if(sc<ec) {
                for(int i=er-1;i>sr;i--) {
                    ans.add(matrix[i][sc]);
                }
            }
            sr++;
            ec--;
            er--;
            sc++;
        }
        return ans;
    }
}