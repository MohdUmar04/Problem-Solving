import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> x - y);
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(i<k)
            heap.add(nums[i]);
            else
            {
                if(nums[i]>heap.peek())
                {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
        }
        return (int)heap.peek();
    }
}