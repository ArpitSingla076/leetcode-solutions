class Pair{
    int row;
    int col;
    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair>q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 || i==m-1 || j==0 || j==n-1) {
                    if(grid[i][j]==1) {
                        q.add(new Pair(i,j));
                        vis[i][j] = true;
                    } 
                }
            }
        }
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            while(q.size()>0) {
                Pair curr = q.poll();
                int r = curr.row;
                int c = curr.col;
                for(int k=0;k<4;k++) {
                    int nrow = r+drow[k];
                    int ncol = c+dcol[k];
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==false && grid[nrow][ncol]==1) {
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol] = true;
                    }
                }
            }

            int count=0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j]==1 && vis[i][j]==false) {
                        count++;
                    }
                }
            }
        return count;
    }
}