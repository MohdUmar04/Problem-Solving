class Solution {
    public int minSwaps(int[] nums) {
        int start = 0;
        int end = 0;
        int count = 0;
        int win = 0;
        int f = 0;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++ )
            count += nums[i]==1?1:0;
        
        while(start < nums.length) {
            end = end%nums.length;

            win +=  nums[end]==1?1:0;
            if( end < count-1 && f == 0){
                end++;
                continue;
            }
            f=1;

            res = Math.min(res,count-win);
            win -=  nums[start]==1?1:0;
            start++;
            end++;         
        }
        return res;
        
    }
}