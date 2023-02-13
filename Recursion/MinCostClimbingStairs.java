public class MinCostClimbingStairs {
    static int climb(int[] arr,int n)
    {
        if(n<=1)
        return 0;
        else{
            int st1=arr[n-1]+climb(arr, n-1);
            int st2=arr[n-2]+climb(arr, n-2);
            return Math.min(st1,st2);
        }
    }
    static int minCost(int[] arr)
    {
        return climb(arr, arr.length);
    }
    public static void main(String[] args) {
        int arr[]={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCost(arr));
    }
}
