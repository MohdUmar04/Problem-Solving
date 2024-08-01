class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int count = 1;

        while( j<nums.length ) {
            if( nums[i] == nums[j] && count == 1) {
                nums[i+1] =
                nums[j];
                count++;
            }
            else if( nums[i] == nums[j] ) {
                j++;
                continue;
            }
            else {
                nums[i+1] = nums[j];
                count = 1;
            }
            j++;
            i++;
        }
        return i + 1;
        
    }
}