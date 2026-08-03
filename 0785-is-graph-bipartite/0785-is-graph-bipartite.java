class Solution {
    public boolean isbip(int[][]adj,int[] vis,int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 0;
        while(q.size()>0) {
            int curr = q.poll();
            int currcol = vis[curr];
            for(int neig: adj[curr]) {
                if(vis[neig]==vis[curr]) return false; 
                if(vis[neig]==-1 && vis[neig]!=currcol) {
                    q.add(neig);
                    vis[neig] = 1-currcol;
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
                if(!isbip(adj,vis,i)) {
                    return false;
                }
            }
        }
        return true;
    }
}