class Solution {
    public int maxProfit(int[] prices) {
        
        int max_profit = 0;
        int min = prices[0];

        for( int i = 1 ;i <prices.length ; i++ ) {
            
            if( prices[i] > min) {
                max_profit = Math.max(max_profit , prices[i] - min); 
            }
            min = Math.min(min, prices[i]);
        }

        return max_profit;

    }
}


