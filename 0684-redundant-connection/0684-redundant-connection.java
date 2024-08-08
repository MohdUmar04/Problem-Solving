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
        else
            return parent[a] = find(parent[a]);
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
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length +1 );
        for(int[] e: edges) {
            int p1= dsu.find(e[0]);
            int p2= dsu.find(e[1]);
            if(p1 == p2) 
                return e;
            dsu.union(e[0],e[1]);
        }
        return new int[]{};
    }
}