class Solution {


//     static String answer(int[] arr, int N) {
//         return solve(arr)? "YES" : "NO"; 
//     }
//     public boolean solve(int[] nums) {
//         int sum=0,n=nums.length;
//         for(int i : nums)
//         sum+=i;
//         if(sum % 2 !=0) return false;
//         boolean[][] dp=new boolean[nums.length][sum/2+1];
//         for(int i=0;i<n;i++) dp[i][0]=true;
//         for(int i=n-2;i>=0;i--){
//             for(int tar=0;tar<sum/2+1;tar++){
//                 dp[i][tar]=(tar-nums[i]>=0?dp[i+1][tar-nums[i]]:false) || dp[i+1][tar]; 
//             }
//         }
//         return dp[0][sum/2]; 
//     }


//     static String answer(int[] arr, int N) {
//     return solve(arr) ? "YES" : "NO";
// }

public boolean canPartition(int[] nums) {
    int sum = 0, n = nums.length;
    for (int i : nums)
        sum += i;
    if (sum % 2 != 0) return false;
    boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
    for (int i = 0; i < n; i++) dp[i][0] = true;
    for (int i = n - 2; i >= 0; i--) {
        for (int tar = 0; tar < sum / 2 + 1; tar++) {
            dp[i][tar] = (tar - nums[i] >= 0 ? dp[i + 1][tar - nums[i]] : false) || dp[i + 1][tar];
        }
    }
    return dp[0][sum / 2];
}

}