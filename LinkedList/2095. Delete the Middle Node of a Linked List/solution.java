class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
            return null;
        if(head.next.next==null)
            {
            head.next=null;
            return head;
            }

 

    ListNode f=head,s=head;
    while(f!=null && f.next!=null)
    {
        
    f=f.next.next;
     s=s.next;
    }
       deleteNode(s);
     
        return head;
    }
  public void deleteNode(ListNode node)
      {
      while(node.next.next!=null)
          {
            node.val=node.next.val;
          node=node.next;
          }
      node.val=node.next.val;
      node.next=null;
      
      
      }
}
