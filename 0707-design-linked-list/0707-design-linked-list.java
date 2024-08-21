class ListNode {
       ListNode next;
       int val;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
class MyLinkedList {
    ListNode head;
    public MyLinkedList() {
        head=null;
    }
    
    public int get(int index) {
        ListNode t=head;
        while(t!=null)
        {
            System.out.print(t.val+" ");
            t=t.next;
        }
        System.out.println();
        ListNode s=head;
        int i=0;
        if(head==null)
        return -1;
        while(s!=null)
        {
            if(i==index)
            return s.val;
            s=s.next;
            i++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode n=new ListNode(val);
        n.next=head;
        head=n;
    }
    
    public void addAtTail(int val) {
        ListNode n=new ListNode(val);
        if(head==null){
            head=n;
        }
        else{
            ListNode s=head;
            while(s.next!=null)
            s=s.next;
            s.next=n;
        }
        
    }
    
    public void addAtIndex(int index, int val) {
        int i;
        if(index==0)
        addAtHead(val);
        else if(head==null)
        {

        }
        else
        {
        ListNode s=head;
        ListNode n=new ListNode(val);
         i=0;
        while(s!=null)
        {
            if(i==index-1)
            {
                n.next=s.next;
                s.next=n;
                break;
            }
            s=s.next;
            i++;
        }
        }
    }
    
    public void deleteAtIndex(int index) {
        if(head==null)
        {}
        else if(index==0)
        {
            head=head.next;
        }
        else
        {
            int i=0;
            ListNode s=head;
            while(s.next!=null)
            {
                if(i+1==index)
                {
                    s.next=s.next.next;
                    break;
                }
                i++;
                s=s.next;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */