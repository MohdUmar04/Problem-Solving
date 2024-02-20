import java.util.*;
public class DFS_Traversal
{
    static List<List<Integer>> graph;
    private static void createGraph(int[][] edges,int v){
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    private static void dfs(int v,boolean[] visited,List<Integer> d){
        visited[v]=true;
        d.add(v);
        for(int vertex : graph.get(v)){
            if(!visited[vertex])
                dfs(vertex,visited,d);
        }
    }
    public static void main(String[] args) {
        int v=9;
        int[][] edges={{1,7},{1,3},{1,2},{2,3},{5,6},{6,8}};
        graph=new ArrayList<>();
        createGraph(edges,v);
        System.out.println("Graph=" +graph);
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        List<Integer> d=new ArrayList<>();
        dfs(1,visited,d);
        System.out.println("DFS: "+(d));
    }
}