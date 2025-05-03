class MinStack {
    Stack<Long> st = new Stack<>();
    long mini = Long.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        long val2 = (long)val;
        if(st.isEmpty()){
            mini = val2;
            st.push(val2);
        } 
        else if(val2 > mini) st.push(val2);
        else{
            st.push(2*val2 - mini);
            mini = val2;
        }
    }
    
    public void pop() {
        if(st.empty()) return;
        long x = st.peek();
        st.pop();
        if(x < mini){
            mini = 2*mini - x;
        }

    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(mini > x) return (int)mini;
        else return (int)x;
    }
    
    public int getMin() {
        if (st.isEmpty()) return -1;
        return (int) mini;
    }
}

