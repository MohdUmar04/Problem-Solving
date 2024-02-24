import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CycleDetection_BFS {
       
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer> vis=new HashSet<>();
        for(int i=0;i<V;i++){
            if(vis.contains(i)==false){
                // System.out.println(i +" "+ vis);
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        vis.add(i);
        Map<Integer,Integer> parent=new HashMap<>();
        parent.put(i,-1);
       
        while(!q.isEmpty()){
            int x=q.poll();
            for(Integer v:adj.get(x)){
                if(v==parent.get(x)) continue;
                if(vis.contains(v)) {
                    // System.out.println(vis +" "+ v + parent.get(115));
                    return true;
                }
                    q.add(v);
                    vis.add(v);
                    parent.put(v,x);
            
            }
        }
    }
    }
     return false;
    }
}