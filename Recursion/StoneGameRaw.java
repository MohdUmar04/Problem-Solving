class StoneGameRaw
{
    public static int solve(int stones[],int left,int right,int alice) {
        if(left>right)
            return 0;

            int left_ans=alice*stones[left]+solve(stones,left+1,right,alice*-1);
            int right_ans=alice*stones[right]+solve(stones,left,right-1,alice*-1);
            return alice==1?Math.max(left_ans,right_ans):Math.min(left_ans,right_ans);
    }
    public static boolean stoneGame(int[] stones) {
        return solve(stones,0,stones.length-1,1)>0?true:false;
        
    }
    public static void main(String[] args) {
        int stones[]={3,7,2,3};
        System.out.println(stoneGame(stones));
        int stones1[]={3,2,7,3};
        System.out.println(stoneGame(stones1));
        int stones2[]={5,3,4,5};
        System.out.println(stoneGame(stones2));
    }
}