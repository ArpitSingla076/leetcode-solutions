class Pair{
    int row;
    int col;
    int diff;
    Pair(int row,int col,int diff) {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}
class Solution {
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        PriorityQueue<Pair>minheap = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        minheap.add(new Pair(0,0,0));
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(minheap.size()>0) {
            Pair curr = minheap.poll();
            int row = curr.row;
            int col = curr.col;
            int diff = curr.diff;
            if(row==m-1 && col==n-1) return diff;
            for(int i=0;i<4;i++) {
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n) {
                    int newEffort = Math.max(Math.abs(arr[row][col]-arr[nrow][ncol]),diff);
                    if(newEffort<dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        minheap.add(new Pair(nrow,ncol,newEffort));
                    }
                }
            } 
        }
        return 0;
    }
}