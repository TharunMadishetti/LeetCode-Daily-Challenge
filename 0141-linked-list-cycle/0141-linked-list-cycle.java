/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    ListNode s=head,f=head;
    while(f!=null && f.next!=null){
        s=s.next;
        f=f.next.next;
        if(f!=null && s!=null && f==s) return true;
        
    }
    return false;
    }
}