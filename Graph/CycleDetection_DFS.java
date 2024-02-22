import java.util.ArrayList;

public class CycleDetection_DFS {
    // Function to detect cycle in an undirected graph.

    static ArrayList<ArrayList<Integer>> graph;
    private static void createGraph(int[][] edges,int v){
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    static boolean solve(int node, ArrayList<ArrayList<Integer>> adj, int parent , boolean[] vis){
        vis[node] = true;
        
        boolean res=false;
        for(int i : adj.get(node)) {
            if(i!= parent && vis[i] == true) return true;
            if(i!=parent) res = (res || solve(i,adj,node,vis));
        }
        return res;
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] vis = new boolean[V];
        
        for(int i=0 ; i <V ; i++)
        if(vis[i]==false)
        if(solve(i,adj,-1,vis)) return true;
        return false;
    }

    public static void main(String[] args) {
        int v=9;
        int[][] edges={{1,7},{1,3},{1,2},{2,3},{5,6},{6,8}};
        graph=new ArrayList<>();
        createGraph(edges,v);
        System.out.println("Graph=" +graph);
        System.out.println(isCycle(v, graph));
        
    }
}
