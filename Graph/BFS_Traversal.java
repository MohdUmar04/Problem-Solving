import java.util.*;
public class BFS_Traversal
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
   
    public static void main(String[] args) {
        int v=9;
        int[][] edges={{1,7},{1,3},{1,2},{2,3},{5,6},{6,8}};
        graph=new ArrayList<>();
        createGraph(edges,v);
        System.out.println(graph);
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        List<Integer> b=new ArrayList<>();
        bfs(1,visited,b);
        System.out.println("BFS: "+(b));
    }
}