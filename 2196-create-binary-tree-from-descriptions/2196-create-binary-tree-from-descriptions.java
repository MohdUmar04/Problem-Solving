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
    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer,TreeNode> map = new HashMap<>();
        TreeNode n1,n2;
        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> s1 = new HashSet<>();

        for(int[] i :  descriptions) {
            if(!map.containsKey(i[0]))
                n1 = new TreeNode(i[0]);
            else 
                n1 = map.get(i[0]);
            if(!map.containsKey(i[1]))
                n2 = new TreeNode(i[1]);
            else
                n2 = map.get(i[1]); 

            map.put(i[0],n1);
            map.put(i[1],n2);
            
            s.add(i[1]);
            s1.add(i[0]);
            if(i[2] == 1){
                n1.left = n2;
            }
            else {
                n1.right = n2;
            }
        }
        for(int i : s1)
        if(!s.contains(i))
        return map.get(i);
        return null;
    }
}