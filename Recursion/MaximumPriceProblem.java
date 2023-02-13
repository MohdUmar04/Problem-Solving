public class MaximumPriceProblem {

    static int MaxProfit(int left,int right,int[] wines,int year){
        if(left==right)
            return wines[left]*year;                                    // year= left+wines.length-right
        else
        {
            int leftCost=wines[left]*year + MaxProfit(left+1, right, wines, year+1);
            int rightCost=wines[right]*year + MaxProfit(left, right-1, wines, year+1);
            return Math.max(leftCost,rightCost);
        }
    }

    static int maxPrice(int[] wines){
        return MaxProfit(0,wines.length-1,wines,1);
    }

    public static void main(String[] args) {
        int wines[]={2,3,5,1,4};
        System.out.println(maxPrice(wines));
    }
}
