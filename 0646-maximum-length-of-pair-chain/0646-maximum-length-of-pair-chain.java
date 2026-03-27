// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
//         int longestChain = 1;
//         int lastEnd = pairs[0][1];

//         for(int i=1;i<pairs.length;i++) {
//             if(pairs[i][0]>lastEnd) {
//                 longestChain++;
//                 lastEnd = pairs[i][1];
//             }
//         }
//         return longestChain;
//     }
// }

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        // {id,start,end}
       int[][] activities = new int[n][3];
       for(int i=0;i<n;i++) {
        activities[i][0] = i;
        activities[i][1] = pairs[i][0];
        activities[i][2] = pairs[i][1];
      }

      // sort by end time
      Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));

      int maxChain = 1;
      int lastEnd = activities[0][2];

      for(int i=1;i<n;i++) {
        if(activities[i][1]>lastEnd) {
            maxChain++;
            lastEnd = activities[i][2];
        }
      }
      return maxChain;
    }
}