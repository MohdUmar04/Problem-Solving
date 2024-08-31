/*lass Solution {
    public int[] twoSum(int[] nums, int target) {
        
    }
}*/
class Solution {
        public int[] twoSum(int[] nums, int target) {
                int i=0,j=0;
                        HashMap<Integer,Integer> map = new HashMap();
                                
                                        for(i=0;i<nums.length;i++){
                                                    if(!(map.containsKey(nums[i])))
                                                                map.put(nums[i],i);
                                                                            if(map.containsKey(target-nums[i]))
                                                                                        {
                                                                                                        j=map.get(target-nums[i]);
                                                                                                                        if(i==j)
                                                                                                                                            continue;
                                                                                                                                                            return new int[]{i,j};}
                                                                                                                                                                    }
                                                                                                                                                                            return new int[]{0,0};
                                                                                                                                                                                }
                                                                                                                                                                                }
