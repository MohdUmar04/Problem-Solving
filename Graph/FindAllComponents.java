import java.util.*;
public class FindAllComponents
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
    private static void bfs(int v,boolean[] visited,List<Integer> b){
        visited[v]=true;
        Queue<Integer> que=new LinkedList<>();
        que.add(v);
        while(!que.isEmpty()){

            int s=que.size();
            while(s-->0){
                int t=que.poll();
                b.add(t);
                for(int vertex: graph.get(t)){
                    if(!visited[vertex]){
                        visited[vertex]=true;
                        que.add(vertex);
                    }
                }
            }

        }
    }
    private static void count(int v,List<List<Integer>> components) {
        boolean[] visited= new boolean[v];
        Arrays.fill(visited,false);
        for(int i=0;i<v;i++){
            
            List<Integer> res= new ArrayList<>();
            if(!visited[i])
            bfs(i,visited,res);
            if(res.size()>0)
            components.add(res);
        }
        
    }
    public static void main(String[] args) {
        int v=9;
        int[][] edges={{1,7},{1,3},{1,2},{2,3},{5,6},{6,8}};
        graph=new ArrayList<>();
        createGraph(edges,v);
        System.out.println(graph);
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        List<Integer> d=new ArrayList<>();
        dfs(1,visited,d);
        System.out.println("DFS: "+(d));
        Arrays.fill(visited,false);
        List<Integer> b=new ArrayList<>();
        bfs(1,visited,b);
        System.out.println("BFS: "+(b));
        List<List<Integer>> components=new ArrayList<>();
        count(v,components);
        System.out.println(components);
    }
}