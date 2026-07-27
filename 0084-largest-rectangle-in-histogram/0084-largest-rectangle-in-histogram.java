class Solution {
    public int largestRectangleArea(int[] heights) {
        // --- Brute force ---
        // int n = heights.length;
        // int max=0;
        // for(int i=0;i<n;i++) {
        //     int minHeight = Integer.MAX_VALUE;
        //     for(int j=i;j<n;j++) {
        //         int w = j-i+1;
        //         minHeight = Math.min(minHeight, heights[j]);
        //         int area = w*minHeight;
        //         max = Math.max(max,area);
        //     }
        // }
        // return max;

        // --- Optimal sol --- 
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        // calculating nse[]
        st.push(n-1); // index
        nse[n-1] = n;
        for(int i=n-2;i>=0;i--) {
            while(st.size()>0 && heights[st.peek()]>=heights[i]) {
                st.pop();
            }
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }

        // empty stack
        while(st.size()>0) st.pop();

        // calculating pse[]
        st.push(0);
        pse[0] = -1;
        for(int i=1;i<n;i++) {
            while(st.size()>0 && heights[st.peek()]>=heights[i]) {
                st.pop();
            }
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        // max area of rectangle
        int max = -1;
        for(int i=0;i<n;i++) {
            int w = (nse[i]-pse[i]-1);
            int h = heights[i];
            int area = w*h;
            max = Math.max(area,max);
        }
        return max;
    }
}