class Pair{
    int row;
    int col;
    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair>q = new LinkedList<>();
        int currcol = image[sr][sc];
        image[sr][sc] = color;
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        while(q.size()>0) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int k=0;k<4;k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==false && image[nrow][ncol]==currcol) {
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol] = true;
                    image[nrow][ncol] = color;
                }
            }
        }
        return image;
    }
}