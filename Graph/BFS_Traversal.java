import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> que=new LinkedList<>();
        ArrayList<Integer> res= new ArrayList<>();
        boolean[] vis = new boolean[V];
        vis[0]=true;
        que.add(0);
        while(!que.isEmpty() ){
            int  n =que.poll();
            res.add(n);
            for(int i : adj.get(n)){
                if(!vis[i])
                {   
                    vis[i]=true;
                    que.add(i);
                }
            }
        }
        return res;
    }
}