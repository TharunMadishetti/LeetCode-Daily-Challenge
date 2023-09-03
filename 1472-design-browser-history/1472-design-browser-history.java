class ListNode
{
    String url;
    ListNode p,next;
    public ListNode(String u)
    {
        url=u;
    }
}
class BrowserHistory {
    ListNode head,curr;
    public BrowserHistory(String homepage) {
        head=new ListNode(homepage);
        curr=head;
    }
    
    public void visit(String url) {
        curr.next=new ListNode(url);
        curr.next.p=curr;
        curr=curr.next;
    }
    
    public String back(int steps) {
        
        while(steps>0 && curr!=null)
        {
            if(curr.p==null)
                break;
            curr=curr.p;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && curr!=null)
        {
            if(curr.next==null)
                break;
            curr=curr.next;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */