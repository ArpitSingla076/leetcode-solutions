class Solution {
    public void bfs(List<List<Integer>> adj,boolean[] vis,int src) {
        int n = adj.size();
        Queue<Integer>q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(q.size()>0) {
            int curr = q.poll();
            for(int neig : adj.get(curr)) {
                if(!vis[neig]) {
                    q.add(neig);
                    vis[neig] = true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        if(src==dest) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        bfs(adj,vis,src);
        return vis[dest];
    }
}