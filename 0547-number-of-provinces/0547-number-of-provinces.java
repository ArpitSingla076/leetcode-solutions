class Solution {
    public void bfs(int[][]adj,boolean[]vis,int i) {
        int n = adj.length;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0) {
            int curr = q.poll();
            for(int j=0;j<n;j++) {
                if(adj[curr][j]==1 && vis[j]==false) {
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                bfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }
}