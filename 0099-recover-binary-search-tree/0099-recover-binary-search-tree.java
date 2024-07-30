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
    List<TreeNode> l=new ArrayList<>();
    List<Integer> v=new ArrayList<>();
    void inorder(TreeNode root)
    {
        if(root!=null){
        inorder(root.left);
        l.add(root);
        v.add(root.val);
        inorder(root.right);}
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        List<Integer> s=new ArrayList<Integer>(v);
        Collections.sort(s);
        // System.out.println(s);
        // System.out.println(v);
        for(int i=0;i<s.size();i++){
            if(s.get(i)!=v.get(i)){
                l.get(i).val=s.get(i);
            }
        }
    }
}