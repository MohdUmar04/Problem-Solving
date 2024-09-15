class Solution {
    char[] s1,s2,s3;
    Boolean[][] dp;
    private boolean solve(int i, int j, int k){
        if(dp[i][j]!=null) return dp[i][j];
        else{
        if(i==s1.length && j==s2.length && k==s3.length)
            return true;
        boolean r1=false;
        if(i!=s1.length && k!=s3.length && s1[i]==s3[k])
            r1=r1 || solve(i+1,j,k+1);
        if(j!=s2.length && k!=s3.length && s2[j]==s3[k])
            r1=r1 || solve(i,j+1,k+1);
        return dp[i][j]=r1;
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1=s1.toCharArray();
        this.s2=s2.toCharArray();
        this.s3=s3.toCharArray();
        dp=new Boolean[101][101];
        return solve(0,0,0);
    }
}