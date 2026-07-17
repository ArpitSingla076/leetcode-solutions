class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];

        // Build the difference array
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from] += passengers; // Passengers enter
            stops[to] -= passengers;   // Passengers leave
        }

        int currentPass = 0;

        // Simulate the journey
        for (int i=0;i<1001;i++) {
            currentPass += stops[i];
            if (currentPass>capacity) {
                return false;
            }
        }
        return true;
    }
}