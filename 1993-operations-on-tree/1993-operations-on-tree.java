class LockingTree {
    Map<Integer,List<Integer>> tree;
    Map<Integer,Integer> locked;

    int[] parent;

    public LockingTree(int[] parent) {
        tree = new HashMap<>();

        this.parent = parent;
        
        for(int i=1;i< parent.length; i++){

            if(!tree.containsKey( parent[i]) )
                tree.put(parent[i], new ArrayList<>());

            tree.get(parent[i]).add(i);
        }
        locked = new HashMap<>();
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num,user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num)) return false;

        if( locked.get(num) != user) return false;

        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num) == true) return false;

        var checkDecendant = descendantLocked(num);

        if( checkDecendant.isEmpty() ) return false;

        if(ancestorLocked(num) == true ) return false;

        for(int i : checkDecendant)
            locked.remove(i);
        
        return  lock(num,user);
        
    }

    public boolean ancestorLocked(int node){
        if(node == -1) return false;

        if(locked.containsKey(node)) return true;

        return ancestorLocked(parent[node]);

    }

    public List<Integer> descendantLocked(int node) {

        List<Integer> result = new ArrayList<>();


        if( locked.containsKey(node)) {
            result.add(node);
        }


        if(!tree.containsKey(node)) return result;

        for(int i : tree.get(node)) {
            result.addAll(descendantLocked(i));
        }
        return result;
    }

}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */