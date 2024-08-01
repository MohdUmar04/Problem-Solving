class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[][] res = new int[intervals.length][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        int j = 0;
        for(int i = 1; i < intervals.length ; i++ ) {
            if(res[j][1] >= intervals[i][0])
            {
                res[j][1] = Math.max(intervals[i][1], res[j][1]);
                continue;
            }
            else{
                j++;
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
            }
        }
        return Arrays.copyOfRange(res,0,j+1);
    }
}