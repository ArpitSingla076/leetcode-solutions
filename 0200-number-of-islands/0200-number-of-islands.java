class Pair{
    int row;
    int col;
    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(char[][] grid,boolean[][] vis,int i,int j) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j] = true;
        while(q.size()>0) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int k=0;k<4;k++) {
                int nrow = row+drow[k];
                int ncol = col+dcol[k];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && vis[nrow][ncol]==false) {
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol] = true;
                }
            }

        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1' && vis[i][j]==false) {
                    bfs(grid,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}