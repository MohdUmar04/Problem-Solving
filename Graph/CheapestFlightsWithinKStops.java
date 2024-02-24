import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static List<List<List<Integer>>> graph;
    private static void createGraph(int[][] flights, int n) {
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            List<Integer> l =new ArrayList<>();
            l.add(flight[1]);
            l.add(flight[2]);
            graph.get(flight[0]).add(l);
            
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] stop = new int[n];
        int[] dis = new int[n];   
        createGraph(flights,n);
        Arrays.fill(stop,Integer.MAX_VALUE);
        Arrays.fill(dis,Integer.MAX_VALUE);
        stop[src] = 0;
        dis[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int[] node = new int[]{src,0,0};
        pq.add(node);
        while(!pq.isEmpty()){
            int[] v = pq.poll();
            if(v[0]==dst) return v[1];
            if(v[2] == k + 1) continue;
            for(List<Integer> l : graph.get(v[0])){
                
                if(v[1]+l.get(1) < dis[l.get(0)]){
                    dis[l.get(0)] = v[1]+l.get(1);
                    stop[l.get(0)] = v[2]+1;
                    
                    int[] newnode = new int[]{l.get(0),v[1]+l.get(1),v[2]+1};
                    pq.add(newnode);
                    
                }
                else if(v[2]+1 < stop[l.get(0)]){
                    int[] newnode = new int[]{l.get(0),v[1]+l.get(1),v[2]+1};
                    pq.add(newnode);
                }
            }
        }
        return -1;
    }
}

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(Solution.findCheapestPrice(4, flights, 0, 3, 1));
    }
    
}