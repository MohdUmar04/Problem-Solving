class Solution {
    public int numSubarraysWithSum(int[] nums, int g) {
        int i=0,j=0,c=0,s=0;
        while(i<nums.length&&j<nums.length)
        {
            s=s+nums[j];
            if(s<g)
            {
                j++;
            }
            else if(s>g)
            {
                i++;
                s=0;
                j=i;
            }
            else
            {
                c++;
                j++;
                if(j==nums.length)
            {
                i++;
                j=i;
                s=0;
            }
            }            
        }
        return c;
    }
}