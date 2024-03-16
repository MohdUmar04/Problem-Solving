import java.util.HashMap;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int s=0,res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1) s+=1;
            else s-=1;
            
            if(s==0) {res=i+1;}
            else if( map.containsKey(s))
            {
                res=Math.max(res,i-map.get(s));
            }
            else map.put(s,i);
        }
        return res;
    }
}