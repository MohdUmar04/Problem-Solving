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
    public List<TreeNode> solve(TreeNode root, Set<Integer> set) {
        if( root == null) return new ArrayList<>();

        

        List<TreeNode> res = solve(root.left,set);

        res.addAll(solve(root.right,set));


        

        if(root.left!= null && set.contains(root.left.val)) {
            if(root.left.left != null)
            res.add(root.left.left);
            if(root.left.right != null)
            res.add(root.left.right);
            root.left = null;
        }
        

        if(root.right!= null && set.contains(root.right.val)) {
          
            if(root.right.left != null)
            res.add(root.right.left);
            if(root.right.right != null)
            res.add(root.right.right);
            root.right = null;
        }

        return res;      


    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> res = new ArrayList<>();

        for(int i : to_delete)
        set.add(i);
        TreeNode droot = new TreeNode(-1,root,null);
        res = solve( droot, set);
        if(!set.contains(root.val))
        res.add(root);
        return res;

    }
}