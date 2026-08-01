class Solution {
    public void bfs(List<List<Integer>> adj,boolean[] vis,int node) {
        int n = adj.size();
        Queue<Integer>q = new LinkedList<>();
        q.add(node);
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

    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(adj,vis,0); // here we put 0(means idx of that node) after that apply bfs
        for(boolean ele : vis) {
            if(ele==false)return false;
        }
        return true;
    }
}