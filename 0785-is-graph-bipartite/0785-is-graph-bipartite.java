class Solution {
    public boolean bfs(int[][]adj,int[]vis,int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while(q.size()>0) {
            int curr = q.poll();
            int currColor = vis[curr];
            for(int neig : adj[curr]) {
                if(vis[neig]==vis[curr]) {
                    return false;
                }
                if(vis[neig]==-1) {
                    vis[neig] = 1-currColor;
                    q.add(neig);
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++) {
            if(vis[i]==-1) {
                if(!bfs(adj,vis,i)) {
                    return false;
                }
            }
        }
        return true;
    }
}