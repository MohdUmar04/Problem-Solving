class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        List<Integer> list = new ArrayList<>();
        int mod = 1_000_000_007;
        int sum = 0;
        for( int i = 0 ; i < n ; i ++ ) {
            sum = 0;
            for( int j = i; j < n ; j ++ ) {
                sum = (sum + nums[j]) % mod;
                
                list.add(sum);
            } 
        }

        Collections.sort(list);
        sum = 0;

        for(int i = left-1; i <= right-1 ; i++ ) {
            sum = (sum + list.get(i)) % mod;
        }
        return sum;

    }
}