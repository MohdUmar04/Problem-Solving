
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    } 
}

class FindBottomLeftTreeValue {
    int res=-1,d=-1;
    private void dfs(TreeNode root, int depth){
        if(root==null) return;
        if(depth>d){ 
            res=root.val;
            d=depth;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        d = -1;
        res =-1;
        dfs(root,0);
        return res;
    }
}