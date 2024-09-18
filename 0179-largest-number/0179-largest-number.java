class Solution {
    public String largestNumber(int[] nums) {
        String ans[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Integer.toString(nums[i]);//store the integers as strings
        }
        Arrays.sort(ans, (a, b) -> (b + a).compareTo(a + b));//sort the array by comparing the first to last didgits
        if(ans[0].equals("0"))
        return "0";//for tc->229
        String largest = "";
        for (String s : ans) {
            largest += s;//store the largest
        }
        return largest;

    }
}