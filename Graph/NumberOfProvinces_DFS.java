import java.util.*;

class Solution1 {
    Map<Integer,List<Integer>> graph;
    private void create(int[][] isConnected,int v){
        for(int i=1;i<=v;i++){
            graph.put(i,new  ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i!=j && isConnected[i][j]==1){
                    graph.get(i+1).add(j+1);
                }
            }
        }
    }
    private void dfs(int curr,boolean[] visited){
        visited[curr]=true;
        for(int i : graph.get(curr)){
            if(!visited[i])
            dfs(i,visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        graph = new HashMap<>();
        create(isConnected,isConnected.length);
        // System.out.println(graph);
        boolean[] visited=new boolean[isConnected.length+1];
        int res=0;
        for(int i=1;i<visited.length;i++){
            if(!visited[i])
            {
                res++;
                dfs(i,visited);
            }
        }
        return res;
    }
}
public class NumberOfProvinces_DFS extends Solution1 {
    public static void main(String[] args) {
        int[][] edges={{1,1,0},{1,1,0},{0,0,1}};
        Solution1 obj = new Solution1();
        System.out.println(obj.findCircleNum(edges));
    }
    
}