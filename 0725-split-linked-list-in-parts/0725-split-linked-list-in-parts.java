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
    private void solve(ListNode head,int k,int div,int extra,int idx,ListNode[] res){
        if(idx==k) return;
        res[idx]=head;
        ListNode ptr1=head, ptr2=null;
        if(extra >0){
            ptr2=ptr1;
            if(ptr1!=null)
            ptr1=ptr1.next;
            extra-=1;
        }
        int d=div;
        while(d-->0){
            ptr2=ptr1;
            ptr1=ptr1.next;
        }
        if(ptr1!=null)
        ptr2.next=null;
        solve(ptr1,k,div,extra,idx+1,res);
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res= new ListNode[k];
        ListNode st=head;
        int len=0;
        while(st!=null){
            len+=1;
            st=st.next;
        }
        int extra= len%k;
        int div=len/k;
        solve(head,k,div,extra,0,res);
        return res;
    }
}