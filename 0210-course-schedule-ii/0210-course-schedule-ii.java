class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        while(q.size()>0) {
            int curr = q.poll();
            ans.add(curr);
            for(int neig : adj.get(curr)) {
                indegree[neig]--;
                if(indegree[neig]==0) {
                    q.add(neig);
                }
            }
        }
        int[] ans2 = new int[n];
        for(int i=0;i<ans.size();i++) {
            ans2[i] = ans.get(i);
        }
        if(ans.size()!=n) return new int[]{};
        else return ans2;
    }
}