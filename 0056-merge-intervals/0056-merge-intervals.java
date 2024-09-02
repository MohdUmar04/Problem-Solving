class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);

        int[][] res = new int[intervals.length][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        int k = 0;

        for(int i=1; i< intervals.length ; i++){
            if( intervals[i][0] <= res[k][1]){
                res[k][1] = Math.max(res[k][1],intervals[i][1]);
            } else{
                k++;
                res[k][0] = intervals[i][0];
                res[k][1] = intervals[i][1];
            }
        }

        return Arrays.copyOfRange(res,0,k+1);
        
    }
}