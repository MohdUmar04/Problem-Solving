class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] r=new int[0][0];
        if(m*n!=original.length) return r;
        int[][] res=new int[m][n];
        int i=0,j=0;
        for(int x: original){
            res[i][j++]=x;
            if(j==n) {i++;j=0;}
        }
        return res;
    }
}