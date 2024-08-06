class Solution {
    List<List<Integer>> graph;
    int seats;
    long fuel;
    private long[] solve(int root,int pre) {
        
        long[] res = new long[2];
        res[0] = 1;
        int f = 0;
        for(int i : graph.get(root)){
            if(i != pre){
                long[] t = solve(i,root);
                res[0] += t[0];
                res[1] += t[1]+ (((t[0]) % seats == 0) ?(t[0])/ seats:(t[0]) / seats +1);
                f=1;
            }
        }
        if(f == 0){
            
        System.out.println(root+" "+res[0] + " ," + res[1]);
            
             return res;}


        System.out.println(root+" "+res[0] + " ," + res[1]);
        return res;
    }

    private void create(int[][] roads){
        int n = -1;
        fuel = (long)0;
        for(int[] r : roads)
        {
            n=Math.max(r[0],n);
            n=Math.max(r[1],n);
        }

        for(int i=0; i<n+1;i++)
            graph.add(new ArrayList<>());

        for(int[] r : roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
    }


    public long minimumFuelCost(int[][] roads, int seats) {
        graph = new ArrayList<>();
        this.seats = seats;
        if(roads.length == 0) return 0;

        create(roads);
        return solve(0,-1)[1];
        
    }
}