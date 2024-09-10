class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode result = head;
        ListNode curr = head, next = head.next;

        while(next != null) {
            int gcd = gcd(curr.val, next.val);
            curr.next = new ListNode(gcd);
            curr.next.next = next;
            curr = next;
            next = curr.next;
        }
        return result;
    }
    int gcd(int a, int b) {
        int temp;
        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}