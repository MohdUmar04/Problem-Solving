/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(matrix[i],-1);
        int top=0,bottom=matrix.length,left=0,right=matrix[0].length;
        while(left<right && top<bottom){
            for(int i=left;i<right;i++)
            {matrix[top][i]=head.val;
                head=head.next;
                if(head==null) break;
            }
            if(head==null) break;
            top++;
            for(int i=top;i<bottom;i++)
            {matrix[i][right-1]=head.val;
                head=head.next;
                if(head==null) break;
            }
            if(head==null) break;
            right--;
            if(!(left<right && top<bottom)) break;

            for(int i=right-1;i>=left;i--)
            {matrix[bottom-1][i]=head.val;
                head=head.next;
                if(head==null) break;
            }
            if(head==null) break;
            bottom--;

            for(int i=bottom -1;i>=top; i--)
            {matrix[i][left]=head.val;
                head=head.next;
                if(head==null) break;
            }
            if(head==null) break;
            left++;
        }
        return matrix;
    }
}