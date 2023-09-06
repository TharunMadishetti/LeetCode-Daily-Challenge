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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans=new ListNode[k];
        
        ListNode t=head;
        int l=0;
        while(t!=null)
        {
            l++;
            t=t.next;
        }
        int s=l/k,rem=l%k;
        t=head;
        int i=0;
        while(t!=null)
        {
            ans[i++]=t;
            int c=1;
            while(c<s)
            {
                c++;
                t=t.next;
            }
            if(rem>0 && s!=0)
            {
                rem--;
                t=t.next;
            }
            if(t!=null)
            {
                ListNode nt=t.next;
                t.next=null;
                t=nt;
            }
        }
        return ans;

    }
}