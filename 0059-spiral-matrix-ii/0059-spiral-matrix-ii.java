class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int k=1;
        int top=0,bottom=matrix.length,left=0,right=matrix[0].length;
        while(left<right && top<bottom){
            for(int i=left;i<right;i++)
                matrix[top][i]=k++;
            top++;
            for(int i=top;i<bottom;i++)
                matrix[i][right-1]=k++;
            right--;
            if(!(left<right && top<bottom)) break;

            for(int i=right-1;i>=left;i--)
                matrix[bottom-1][i]=k++;
            bottom--;

            for(int i=bottom -1;i>=top; i--)
                matrix[i][left]=k++;
            left++;
        }
        return matrix;
    }
}