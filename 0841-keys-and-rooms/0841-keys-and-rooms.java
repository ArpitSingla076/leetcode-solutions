class Solution {
    public void bfs(List<List<Integer>> adj,boolean[] vis,int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0) {
            int curr = q.poll();
            for(int ele : adj.get(curr)) {
                if(!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(adj,vis,0);
        for(boolean ele : vis) {
            if(ele==false) return false;
        }
        return true;
    }
}