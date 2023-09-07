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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode nhead=new ListNode(-501);
        nhead.next=head;
        head=nhead;
        ListNode t=head,prev=head;
        int c=-1;
        while(t!=null){
            c++;
            if(left==c){
                ListNode rrev=t;
                while(t!=null && c!=right){
                    c++;
                    t=t.next;
                }
                ListNode ri=t.next;
                t.next=null;
                ListNode rev=reverse(rrev);
                prev.next=rev;
                rrev.next=ri;
                break;
            }
            prev=t;
            t=t.next;
        }
        
        return head.next;
    }
     public ListNode reverse(ListNode h){
        if(h==null || h.next==null)
            return h;
        ListNode k=reverse(h.next);
        h.next.next=h;
        h.next=null;
        // System.out.println(h.val);
        return k;
    }
}