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
    public ListNode partition(ListNode head, int x) {
        ListNode sm=new ListNode(-101);
        ListNode g=new ListNode(-101);
        ListNode smh=sm,gh=g,t=head;
        while(t!=null)
        {
            if(t.val<x)
            {
                sm.next=new ListNode(t.val);
                sm=sm.next;
            }
            else
            {
                g.next=new ListNode(t.val);
                g=g.next;
            }
            t=t.next;
        }
        sm.next=gh.next;
        return smh.next;
    }
}