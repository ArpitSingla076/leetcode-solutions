// -- Brute force(generating all substring) --
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxlen = 0;
//         for(int i=0;i<n;i++) {
//             HashSet<Character> set = new HashSet<>();
//             for(int j=i;j<n;j++) {
//                 char ch = s.charAt(j);
//                 if(set.contains(ch)) break;
//                 set.add(ch);
//                 maxlen = Math.max(maxlen,j-i+1);
//             }
//         }
//         return maxlen;
//     }
// }


// -- Optima Sol (using two pointer and sliding window(HashSet)) --
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//       int n = s.length();
//       int left = 0;
//       int maxlen = 0;
//       HashSet<Character> set = new HashSet<>();
//       for(int right=0;right<n;right++) {
//         char ch = s.charAt(right);
//         while(set.contains(ch)) {
//             set.remove(s.charAt(left));
//             left++;
//         }
//         set.add(ch);
//         maxlen = Math.max(maxlen,right-left+1);
//       }
//       return maxlen;
//     }
// }


// -- Optima Sol (using two pointer and sliding window(HashMap)) --
class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n = s.length();
      int left = 0;
      int maxlen = 0;
      HashMap<Character,Integer> map = new HashMap<>();
      for(int right=0;right<n;right++) {
        char ch = s.charAt(right);
        if(map.containsKey(ch)) {
            left = Math.max(left,map.get(ch)+1);
        }
        map.put(ch,right);
        maxlen = Math.max(maxlen,right-left+1);
      }
      return maxlen;
    }
}