// -- Brute force(genrate all substring(using hashset)) --
// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int count = 0;
//         for(int i=0;i<n;i++) {
//             HashSet<Character> set = new HashSet<>();
//             for(int j=i;j<n;j++) {
//                 set.add(s.charAt(j));
//                 if(set.contains('a') && set.contains('b') && set.contains('c')) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }


// -- Brute force(genrate all substring(using hashMap)) --
// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int count = 0;
//         for(int i=0;i<n;i++) {
//             HashMap<Character,Integer> map = new HashMap<>();
//             for(int j=i;j<n;j++) {
//                 char ch = s.charAt(j);
//                 map.put(ch,map.getOrDefault(ch,0)+1);
//                 if(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }


// -- Optimal (using sliding window) --
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0;
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int r=0;r<n;r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // when valid
            while (map.size()==3) {
                count += (n-r);
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }
        }
        return count;
    }
}