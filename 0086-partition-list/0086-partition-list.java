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
    public ListNode partition(ListNode h, int x) {
        if(h==null)
        return h;
        ListNode st=h;
        ListNode sm=new ListNode(-1);
        ListNode ll=new ListNode(-1);
        ListNode cs=sm,cl=ll;
        while(st!=null)
        {
            if(st.val<x)
            {
                ListNode n=new ListNode(st.val);
                cs.next=n;
                cs=cs.next;
            }
            else
            {
                ListNode n=new ListNode(st.val);
                cl.next=n;
                cl=cl.next;
            }
            st=st.next;
        }
        cs.next=ll.next;
        return sm.next;
    }
}