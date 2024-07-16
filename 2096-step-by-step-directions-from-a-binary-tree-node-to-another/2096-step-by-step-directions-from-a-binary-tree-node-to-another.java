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

    private String[] solve(TreeNode root, TreeNode dest, String s, TreeNode pre){
        if(root == dest) return new String[]{"" , "1"};
        else if(root == null) return new String[]{"", "0"};
        else {
            String[] l=new String[]{"", "0"};
            String[] r=new String[]{"", "0"};
            String[] p =new String[]{"", "0"};
            if(root.left != pre)
           l = solve(root.left, dest , "L", root);
            if(l[1].equals("1"))
            {
                l[0]= "L"+l[0];
                return l;
            }

            if(root.right != pre)
            r = solve(root.right, dest , "R", root);
            if(r[1].equals("1"))
            {
                r[0]= "R"+r[0];
                return r;
            }
            if(map.get(root) != pre)
            p = solve(map.get(root), dest , "P", root);

            if(p[1].equals("1"))
            {
                p[0]= "U"+p[0];
                return p;
            }
            return new String[]{"",""};
            


        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        map = new HashMap<>();
        start=null;
        end = null;
        this.startValue = startValue;
        this.destValue = destValue;

        findPar(root, null);
        

        return solve(start,end, " ",null)[0];

    }
}