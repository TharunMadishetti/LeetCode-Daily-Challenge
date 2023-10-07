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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nhead=new ListNode(-101);
        nhead.next=head;
        ListNode s=nhead,f=nhead.next;
        while(f!=null)
        {
            int x=f.val;
            ListNode p=f;
            int c=0;
            while(f!=null && x==f.val)
            {
                c++;
                p=f;
                f=f.next;
            }
            // System.out.println(p.val+" "+c);
            if(c==1)
            {
                s.next=p;
                s=s.next;
            }
           
        }
        s.next=null;
        return nhead.next;
    }
}