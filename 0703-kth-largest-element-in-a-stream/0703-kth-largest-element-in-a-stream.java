class KthLargest {

    PriorityQueue<Integer> minheap=new PriorityQueue<>();

    int s;

    public KthLargest(int k, int[] nums) {

        s=k;

        for(int i:nums)

        {

            minheap.offer(i);

            if(minheap.size()>s)

            minheap.poll();

        }

    }

    

    public int add(int val) {

        minheap.offer(val);

        while(minheap.size()>s)

            minheap.poll();

        return minheap.peek();

        

    }

}

/**

 * Your KthLargest object will be instantiated and called as such:

 * KthLargest obj = new KthLargest(k, nums);

 * int param_1 = obj.add(val);

 */
/*
class KthLargest {

    public KthLargest(int k, int[] nums) {
        
    }
    
    public int add(int val) {
        
    }
}*/

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */