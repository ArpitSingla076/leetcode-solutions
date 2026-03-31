// -- Brute force(generate all subarrays(using Hashset)) --

// class Solution {
//     public int totalFruit(int[] fruits) {
//         int n = fruits.length;
//         int maxlen = 0;
//         for(int i=0;i<n;i++) {
//             HashSet<Integer> set = new HashSet<>();
//             for(int j=i;j<n;j++) {
//                 set.add(fruits[j]);
//                 if(set.size()<=2) {
//                     maxlen = Math.max(maxlen,j-i+1);
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         return maxlen;
//     }
// }

// -- Brute force(generate all subarrays(using HashMap)) --

// class Solution {
//     public int totalFruit(int[] fruits) {
//         int n = fruits.length;
//         int maxlen = 0;
//         for(int i=0;i<n;i++) {
//             HashMap<Integer,Integer> map = new HashMap<>();
//             for(int j=i;j<n;j++) {
//                 map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);
//                 if(map.size()<=2) {
//                     maxlen = Math.max(maxlen,j-i+1);
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         return maxlen;
//     }
// }

// -- Optimal Sol (using sliding window) --
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxlen = 0;
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<n;right++) {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2) {
                map.put(fruits[left],map.get(fruits[left])-1);

                if(map.get(fruits[left])==0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}