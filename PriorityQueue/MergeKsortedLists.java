import java.util.*;
//Definition for singly-linked list.
    class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class MergeKsortedLists {
    public ListNode inatbeg(ListNode l,Integer a)
    {
        if(l!=null){
        ListNode n=new ListNode(a);
        ListNode st=l;
        ListNode t=n;
        while(st.next!=null)
        st=st.next;
        st.next=t;}
        else
        {
            ListNode n=new ListNode(a,null);
            l=n;
        }
        return l;
    }
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode t=null;
    PriorityQueue<Map.Entry<Integer,ListNode>> minheap = new PriorityQueue<>((a,b)->a.getValue().val-b.getValue().val);
    HashMap<Integer,ListNode> map=new HashMap<>();
    int i;
        for(i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            map.put(i,lists[i]);
        }
        for(Map.Entry<Integer,ListNode> entry : map.entrySet()) {
			minheap.offer(entry);
		}
        Map.Entry<Integer,ListNode> e;
        while(!minheap.isEmpty())
        {
            
            e=minheap.poll();
            Integer j=e.getKey();
            Integer z=e.getValue().val;
            System.out.println(z);
            t=inatbeg(t,e.getValue().val);
             if(lists[j].next!=null){
                 lists[j]=lists[j].next;
               e.setValue(lists[j]);
               minheap.offer(e);
            }

        }
        return t;
    }
}