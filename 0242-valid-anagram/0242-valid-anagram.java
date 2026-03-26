// -- Using Sorting(convert to charArray) --
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] arr = s.toCharArray();
//         char[] arr2 = t.toCharArray();
//         Arrays.sort(arr);
//         Arrays.sort(arr2);

//        return Arrays.equals(arr,arr2);
//     }
// }


// -- Using HashMap --
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length()) return false;
//         HashMap<Character,Integer> map = new HashMap<>();
//         HashMap<Character,Integer> map2 = new HashMap<>();

//         for(char ch : s.toCharArray()) {
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }

//         for(char ch : t.toCharArray()) {
//             map2.put(ch,map2.getOrDefault(ch,0)+1);
//         }
//         return map.equals(map2);
//     }
// }

// -- Optimal(using freq array) --
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i<s.length();i++) {
            freq1[s.charAt(i)-'a']++;
            freq2[t.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++) {
            if(freq1[i]!=freq2[i]) return false;
        }
        return true;
    }
}
