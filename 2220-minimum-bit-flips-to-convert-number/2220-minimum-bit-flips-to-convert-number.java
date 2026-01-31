class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cnt=0;
        for(int i=0;i<31;i++) {
            if((ans>>i)%2==1) {
                cnt++;
            }
        }
        return cnt;
    }
}