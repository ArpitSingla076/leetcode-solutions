class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum=0;
        int count=0;
        HashMap<Integer,Integer>map = new HashMap<>(); // (Rem,freq)
        map.put(0,1);
        for(int val : nums) {
            sum+=val;
            int rem = sum%k;
            if(rem<0) rem = rem+k;
            if(map.containsKey(rem)) {
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}