class MinStack {
    long mini = Long.MAX_VALUE;
    Stack<Long> st = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        long val2 = (long) val;
        if(st.isEmpty()){
            st.push(val2);
            mini = val2;
        }
        else if(val2 > mini) {
            st.push(val2);
        }
        else{
            st.push(2*val2 - mini);
            mini = val2;
        }    
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        else{
            long x = st.peek();
            st.pop();
            if(x < mini){
                mini = 2*mini - x;
            }
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(x < mini) return (int)mini;
        return (int)x;
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */