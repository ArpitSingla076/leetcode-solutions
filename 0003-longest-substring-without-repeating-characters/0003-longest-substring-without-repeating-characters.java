class Solution {
    public int lengthOfLongestSubstring(String s) {
        // --------- Brute force(genrate all substring) ----------
        // int n = s.length();
        // int maxlen = 0;
        // for(int i=0;i<n;i++) {
        //     HashSet<Character>set = new HashSet<>();
        //     for(int j=i;j<n;j++) {
        //         char ch = s.charAt(j);
        //         if(set.contains(ch)) break;
        //         set.add(ch);
        //         maxlen = Math.max(maxlen,j-i+1);
        //     }
        // }
        // return maxlen;


        // ---- two pointer & sliding window(using Hashset) ----
        int n = s.length();
        int l=0;
        int r=0;
        int maxlen=0;
        HashSet<Character> set = new HashSet<>();
        for(r=0;r<n;r++) {
            char ch = s.charAt(r);
            while(set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}