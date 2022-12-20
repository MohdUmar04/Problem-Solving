import java.util.*;
    class point{
    int x,y,d;
    public point(int x,int y,int d)
    {
        this.x=x;
        this.y=y;
        this.d=d;
    }
}
class KClosestPointToOrigin {
    public int[][] kClosest(int[][] p, int k) {
        PriorityQueue<point> maxheap=new PriorityQueue<>((p1,p2)->p2.d-p1.d);
        int i,x,y,d;
        for(i=0;i<p.length;i++)
        {
            x=p[i][0];
            y=p[i][1];
            d=(x*x)+(y*y);
            point obj=new point(x,y,d);
            if(i<k)
            {
                maxheap.add(obj);
            }
            else
            {
                maxheap.add(obj);
                maxheap.poll();
            }
        }
        int ans[][] = new int[k][2];
         i = 0;
        while(!maxheap.isEmpty()) {
            point ob = maxheap.poll();
            ans[i][0] = ob.x;
            ans[i][1] = ob.y;
            i += 1;
        }
        return ans;
        
    }
}