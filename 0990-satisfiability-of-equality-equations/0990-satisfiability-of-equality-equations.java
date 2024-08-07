class DSU {
    int[] parent;
    DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
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
            parent[aParent] = bParent;
        }
    }

}

class Solution {   
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for(String s : equations) {
            if(s.charAt(1) != '!') dsu.union(s.charAt(0) - 97, s.charAt(3) - 'a');
        }

        for(String s : equations) {
            if(s.charAt(1) == '!') {
                if(dsu.find(s.charAt(0)-'a') == dsu.find(s.charAt(3)-'a')) return false;
            }
        }
        return true;
    }
}