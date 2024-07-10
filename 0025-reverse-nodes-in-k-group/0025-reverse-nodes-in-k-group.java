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
 class Solution2 {
    ListNode ptr;
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        else
        {
            ptr=reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return ptr;
        }
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int st=0;
        ListNode check= head;
        while(check !=null){
            st++;
            if(st==k) break;
            check=check.next;
        }
        if(check==null) return head;
        ListNode recur= reverseKGroup(check.next,k);
        check.next=null;
        Solution2 obj= new Solution2();
        obj.reverseList(head);
        head.next=recur;
        return check;

    }
}