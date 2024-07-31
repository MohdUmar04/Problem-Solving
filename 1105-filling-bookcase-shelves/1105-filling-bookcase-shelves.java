class Solution {
    int val, zal;
    int[][] book;
    Integer[] dp;

    int solve(int i){
        if(i==book.length) return 0;
        if(dp[i] != null)  return dp[i];
        int res=10000000;
        int curr = 0;
        int j=val;
        int x= i;
        while(book[i][0] <= j){
            curr = Math.max(curr, book[i][1]);
            j-=book[i][0];
            res = Math.min(res,curr+solve(i+1 ));
            
            i++;
            if(i== book.length) break;
        }
        return  dp[x] = res;

    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new Integer[books.length+1];
        this.book = books;
        val = shelfWidth;
        return solve(0);
        
        
    }
}