class Solution {
    public int pivotInteger(int n) {
        int sum=(int)( n/2.0*(1+n));
        int s=0;
        for(int i=1;i<=n;i++){
            s+=i;
            if(sum-s+i == s) return i;
        }
        return -1;
        
    }
}