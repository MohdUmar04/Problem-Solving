class CustomStack {
    int[] stk;
    int t;
    public CustomStack(int maxSize) {
        stk=new int[maxSize];
        t=-1;
    }
    
    public void push(int x) {
        if(t+1!=stk.length)
        {
            t++;
            stk[t]=x;
        }

        
    }
    
    public int pop() {

        if(t==-1)
        return -1;
        else
        {
            int k=stk[t];
            t--;
            return k;
        }
        
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k&&i<stk.length;i++)
        stk[i]+=val;
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */