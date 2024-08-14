class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] freq = new int[1000001];

        for(int i=0;i< nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                freq[Math.abs(nums[i] - nums[j])] ++;
            }
        }
        int i=0;
    
        while(k>0  ){
        k-= freq[i];
        i++;
        }


        
        return i-1;
    }
}