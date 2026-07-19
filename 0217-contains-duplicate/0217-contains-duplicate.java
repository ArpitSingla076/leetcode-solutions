class Solution {
    public boolean containsDuplicate(int[] nums) {
        // int n = nums.length;
        // HashSet<Integer>set = new HashSet<>();
        // for(int val : nums) {
        //     if(set.contains(val)) return true;
        //     set.add(val);
        // }
        // return false;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val,map.getOrDefault(val,0)+1);
        }
        for(int key : map.keySet()) {
            if(map.get(key)>1) return true;
        }
        return false;
    }
}