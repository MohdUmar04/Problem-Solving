class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int a) {
        if(a == parent[a]) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }

    void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent != bParent) {

            if(rank[aParent] > rank[bParent])
                parent[aParent] = bParent;
            else if(rank[aParent] < rank[bParent])
                parent[bParent] = aParent;
            else {
                parent[aParent] = bParent;
                rank[aParent]++;
            }

        }
    }

}


class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] e : edges) {
            dsu.union(e[0],e[1]);
        }
        long res = 0L;

        Map<Long,Long> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++) 
        {
            int f = dsu.find(i);
            map.put((long) f,(long)map.getOrDefault((long)f,0L)+1);
        }
            

        

        for(var v : map.entrySet()) 
            res += v.getValue() * (n-v.getValue());
        return res/2;
    }
}