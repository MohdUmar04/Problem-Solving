class Solution {
    int findmin(int[] arr){
        int i=0,min = arr[0];
        for(int j=0;j<arr.length;j++){
            if(arr[j] < min){
                i=j;
                min = arr[j];
            }
        }
        return i;
    }
    boolean findMax(int[][] arr, int i, int j){
        int max = arr[0][j];
        for(int l = 0; l<arr.length;l++){
            if(max < arr[l][j]){
                max=arr[l][j];
            }
        }
        return max == arr[i][j];
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i< matrix.length;i++){
            int j = findmin(matrix[i]);
            if( findMax(matrix,i,j) )
                res.add(matrix[i][j]);
        }
        return res;
    }
}