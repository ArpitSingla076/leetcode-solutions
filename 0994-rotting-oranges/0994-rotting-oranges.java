class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair>q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int fresh = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2 && vis[i][j]==false) {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
                if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }
        int time=0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(q.size()>0) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
         //   We are finding the time at which the LAST orange becomes rotten.
            time = Math.max(time,t);
            for(int k=0;k<4;k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==false && grid[nrow][ncol]==1) {
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = true;
                    grid[nrow][ncol] = 2;
                    fresh--;
                }
            }
        }
        if(fresh==0) return time;
        else return -1;
    }
}












// class Pair {
//     int row;
//     int col;
//     int time;

//     public Pair(int row, int col, int time) {
//         this.row = row;
//         this.col = col;
//         this.time = time;
//     }
// }

// class Solution {
//     public int orangesRotting(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         Queue<Pair> q = new LinkedList<>();
//         int[][] vis = new int[m][n];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 2) {
//                     q.add(new Pair(i, j, 0));
//                     vis[i][j] = 2;
//                 } else {
//                     vis[i][j] = 0;
//                 }
//             }
//         }
//         int time = 0;
//         int drow[] = {-1,0,1,0};
//         int dcol[] = {0,1,0,-1};

//         while (!q.isEmpty()) {
//             int r = q.peek().row;
//             int c = q.peek().col;
//             int t = q.peek().time;
//             q.poll();
//             time = Math.max(time, t);

//             for (int i = 0; i < 4; i++) {
//                 int nrow = r + drow[i];
//                 int ncol = c + dcol[i];

//                 if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
//                     && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
//                     q.add(new Pair(nrow, ncol, t+1));
//                     vis[nrow][ncol] = 2;
//                 }
//             }
//         }
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (vis[i][j] != 2 && grid[i][j] == 1) {
//                     return -1;
//                 }
//             }
//         }
//         return time;
//     }
// }