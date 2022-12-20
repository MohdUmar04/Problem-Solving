import java.util.*;
class MinimumNumberofRefuelingStops {
    public int minRefuelStops(int t, int sf, int[][] stations) {
        int sto=0;
        int cf=sf;
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        for(int st[]:stations)
        {
            int p= st[0];
            int f=st[1];
            while(cf<p)
            {
                if(maxheap.size()==0)
                return -1;
                cf+=maxheap.poll();
                sto++;
            }
            maxheap.offer(st[1]);
        }
        while(cf<t){
            if(maxheap.isEmpty())
            return -1;
        cf+=maxheap.poll();
        sto++;
        }
        return sto;
    }
}