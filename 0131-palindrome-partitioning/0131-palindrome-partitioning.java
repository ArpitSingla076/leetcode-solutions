class Solution {
    public boolean isPalin(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        if(s.equals(rev)) {
            return true;
        }
        return false;
      
    }

    public void helper(String s,List<String> sub,List<List<String>> ans) {
        // base case
        if(s.length()==0) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        // kaam
        for(int i=0;i<s.length();i++) {
            String part = s.substring(0,i+1);
            if(isPalin(part)) {
                sub.add(part);
                helper(s.substring(i+1),sub,ans);

                // backtracking step
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        helper(s,sub,ans);
        return ans;
    }
}