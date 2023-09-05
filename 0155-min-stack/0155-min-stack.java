class MinStack {
    class Pair
    {
        int a,m;
        Pair(int a,int m)
        {
            this.a=a;
            this.m=m;
        }
        public String toString()
        {
            return "{ "+a+" "+m+" }\n";
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        int mn;
        if(st.isEmpty())
            mn=val;
        else
            mn=Math.min(st.peek().m,val);
        st.push(new Pair(val,mn));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().a;
    }
    
    public int getMin() {

        return st.peek().m;      
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