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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int x=len(head)-n+1;    // calculates the index/position from front 
        if(x==1)
            return head.next;
        int i=0;
        ListNode t=head;
        while(++i<x-1)
           t=t.next;    //traverse nodes until you reach node just before the node to be deleted
        t.next=t.next.next; //now delete the next node by linking the next node to present node
        return head;
    }
    public int len(ListNode h)
    {
        if(h==null)
            return 0;
        return 1+len(h.next);
    }
}
