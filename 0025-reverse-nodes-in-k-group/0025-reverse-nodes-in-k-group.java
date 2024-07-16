/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode rev(ListNode head){
        if(head == null) return null;
        ListNode pre = null, temp =null;
        while(head!=null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp; 
        }
        return pre;
    }

    private ListNode solve(ListNode head, int k){
        if( head == null ) return  null;

        int t = k;
        ListNode dhead1 = head,pre =null;
        ListNode dhead2 = head;


        while(t!=0){
            pre = dhead1;
            if(dhead1 == null) return head;
            dhead1=dhead1.next;
            t--;
        }

        pre.next = null;

        ListNode res = rev(head);
        dhead2.next = solve(dhead1,k);
        return res;

    }
    public ListNode reverseKGroup(ListNode head, int k) {

        return solve(head, k);

    }
}