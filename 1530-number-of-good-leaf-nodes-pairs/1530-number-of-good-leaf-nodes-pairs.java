/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> map;
    Set<TreeNode> set;
    private void findPar(TreeNode current, TreeNode pre) {

        if(current == null) return;
        if(current.left == null && current.right == null) set.add(current);

        map.put(current, pre);
        findPar(current.left, current);
        findPar(current.right, current);
    }
    private int bfs(TreeNode root, int d){
        Queue<TreeNode> que = new LinkedList<>();
        int res = 0;
        que.add(root);
        Set<TreeNode> s = new HashSet<>();
        s.add(root);
        while(!que.isEmpty()){
            int si = que.size();
            while(si-- > 0){
                TreeNode t = que.poll();
                if(set.contains(t))
                     res++;

                if(t.left != null && !s.contains(t.left)) {
                que.add(t.left);
                s.add(t.left);
                }

                if(t.right != null && !s.contains(t.right)) {
                que.add(t.right);
                s.add(t.right);
                }

                if(map.get(t) != null && !s.contains(map.get(t))) {
                que.add(map.get(t));
                s.add(map.get(t));
                }
            }
            d--;
            if(d+1 == 0)
            return (res-1);


        }
        return res-1;
        
    }
    public int countPairs(TreeNode root, int distance) {
        set = new HashSet<>();
        map = new HashMap<>();
        findPar(root,null);
        int res = 0;
        for(TreeNode t : set){
            res+=bfs(t, distance);
        }
        return res/2;

    }
}