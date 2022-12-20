import java.util.*;
class topKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashmap=new HashMap<>();
        for(int a:nums)
            hashmap.put(a,hashmap.getOrDefault(a,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> minheap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        
        for(Map.Entry<Integer,Integer> e:hashmap.entrySet())
        {
            minheap.add(e);
            if(minheap.size()>k)
                minheap.poll();
        }
        int[] a=new int[k];
        int i=0;
        while(!minheap.isEmpty())
            a[i++]=minheap.poll().getKey();
        return a;
    }
}