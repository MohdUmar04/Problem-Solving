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

class Data{
    TreeNode node;
    StringBuilder path;
    TreeNode pre;
    Data(TreeNode t, StringBuilder p, TreeNode pre) {
        this.node = t;
        this.path = p;
        this.pre = pre;
    }
}
class Solution {
    Map<TreeNode,TreeNode> map;
    TreeNode start,end;
    int startValue;
    int destValue;
    private void findPar(TreeNode current, TreeNode pre) {

        if(current == null) return;
        if(current.val == startValue) start = current;
        if(current.val == destValue) end = current;

        map.put(current, pre);
        if(start != null && end != null) return;
        findPar(current.left, current);
        findPar(current.right, current);
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        map = new HashMap<>();
        this.startValue = startValue;
        this.destValue = destValue;

        findPar(root, null);
        Queue<Data> que = new LinkedList<>();

        que.add(new Data(start,new StringBuilder(),null));

        while(!que.isEmpty()){
            
            Data d = que.poll();
            StringBuilder cpath = d.path;

            if(d.node == end) return cpath.toString();

                        
            if( d.node.left != null &&  d.node.left != d.pre)
            que.add(new Data(d.node.left, new StringBuilder(cpath).append("L"), d.node));
                if( d.node.right != null &&  d.node.right != d.pre)
            que.add(new Data(d.node.right, new StringBuilder(cpath).append("R"), d.node));

                if( map.get(d.node) != null &&  map.get(d.node) != d.pre)
            que.add(new Data(map.get(d.node), new StringBuilder(cpath).append("U"), d.node));


        }
        return " ";



    }
}