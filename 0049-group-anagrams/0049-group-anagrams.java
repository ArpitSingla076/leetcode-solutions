class Solution {
    public boolean isAnagram(String p,String q) {
        if(p.length()!= q.length()) return false;
        char[] arr = p.toCharArray();
        char[] arr2 = q.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        return Arrays.equals(arr,arr2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] vis  = new boolean[n];
        for(int i=0;i<n;i++) {
            if(vis[i]) continue;
            List<String> sub = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if(!vis[j] && isAnagram(strs[i],strs[j])) {
                    sub.add(strs[j]);
                    vis[j] = true;
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}