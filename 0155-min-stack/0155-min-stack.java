class Pair{
    int val;
    int minval;
    Pair(int val,int minval) {
        this.val=val;
        this.minval=minval;
    }
}
class MinStack {
    Stack<Pair> st = new Stack<>(); // val,minval
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.size()==0) {
            st.push(new Pair(val,val));
        }
        else{
            int minval = Math.min(val,st.peek().minval);
            st.push(new Pair(val,minval));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().minval;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */