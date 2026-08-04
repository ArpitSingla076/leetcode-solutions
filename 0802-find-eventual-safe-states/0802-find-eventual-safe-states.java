class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int n = adj.length;
        List<Integer>ans = new ArrayList<>();
        List<List<Integer>>adjRev = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        // reverse the graph
        for(int i=0;i<n;i++) {
            for(int ele : adj[i]) {
                // in orig graph,edge is from i-> ele
                // in rev graph,edge is from ele->i
                adjRev.get(ele).add(i);
                indegree[i]++;
            }
        }

        // apply Kahn's Algo
        Queue<Integer>q = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        while(q.size()>0) {
            int curr = q.poll();
            ans.add(curr);
            for(int neig : adjRev.get(curr)) {
                indegree[neig]--;
                if(indegree[neig]==0) {
                    q.add(neig);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}