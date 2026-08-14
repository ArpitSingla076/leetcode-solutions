class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(st.size()>0 && st.peek()==ch) {
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        // for(char ch : st) { // traversing the stack gives the original order.
        //     sb.append(ch);
        // }
        // return sb.toString();

        // +++ OR ++
        while(st.size()>0) { // popping gives reverse order;
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}