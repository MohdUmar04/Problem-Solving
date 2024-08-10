class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length ; i++ ){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(Math.abs(res-target)> Math.abs(nums[i]+nums[j]+nums[k] - target))
                    res=nums[i]+nums[j]+nums[k];
                }
            }
        }
        return res;

    }
}