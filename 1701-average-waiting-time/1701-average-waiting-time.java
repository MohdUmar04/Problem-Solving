class Solution {
    public double averageWaitingTime(int[][] customers) {
        int curr = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] a : customers) {
            if(curr < a[0]){
                curr = a[0] + a[1] -1;
                res.add(a[1]);
            }
            else {
                curr += a[1];
                res.add(curr - a[0] +1);
            }
        }
        long r = (long)0;
        for(int i : res) r+=i;
        return (r/(customers.length*1.0));

    }
}