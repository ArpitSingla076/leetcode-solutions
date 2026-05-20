class Solution {
    public void bfs(List<List<Integer>> adj,boolean[] vis,int i) {
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
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
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            // List<Integer> sub = new ArrayList<>();
            // adj.add(sub);
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        boolean[] vis = new boolean[n];
        bfs(adj,vis,start);
        return vis[end];
    }
}