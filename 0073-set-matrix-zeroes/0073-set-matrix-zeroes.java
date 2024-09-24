class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> row=new LinkedList<>();
        List<Integer> col=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i : row){
            Arrays.fill(matrix[i],0);
        }
        for(int j : col){
            for(int k=0;k<matrix.length;k++){
                matrix[k][j]=0;
            }
        }
    }
}