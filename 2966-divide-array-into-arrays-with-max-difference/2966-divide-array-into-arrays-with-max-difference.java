class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int r=2;
        int[][] res=new int[nums.length/3][3];
        for(int i=0;i<nums.length;i++){
            int j=i/3;
            r=(r+1)%3;
            res[j][r]=nums[i];
            if(nums[i]-res[j][0]>k) return new int[0][0];
        }
        return res;
    }
}