class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int t=0;
        for(int i=0;i< tickets.length;i++)
        {
            if(i<k){
                t+=Math.min(tickets[k],tickets[i]);
            }
            else if(i>k){
                t+=Math.min(tickets[k]-1,tickets[i]);
            }
        }
        return t+tickets[k];
        
    }
}