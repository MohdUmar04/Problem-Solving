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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;
        if(depth == 1){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res; 
        }
        depth --;
        if(depth == 1){
            TreeNode res1 = new TreeNode(val);
            TreeNode res2 = new TreeNode(val);
            res1.left = root.left;
            res2.right = root.right;
            root.left=res1;
            root.right = res2; 
        }
        if(depth>1){
            addOneRow(root.left,val,depth);
            addOneRow(root.right,val,depth);

        }
        return root;
    }
}