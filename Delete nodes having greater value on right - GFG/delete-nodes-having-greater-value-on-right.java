//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        Node p=reverse(head),t;
        Node rh=p;
        int mx=-1;
        t=p;
        mx=t.data;
        t=t.next;
        while(t!=null)
        {
            while(t!=null && mx>t.data)
            t=t.next;
            if(t!=null)
            mx=t.data;
            p.next=t;
            p=p.next;
            if(t!=null)
            t=t.next;
        }
        
        return reverse(rh);
    }
    public Node reverse(Node head)
    {
        Node p=null,t=head;
        while(t!=null)
        {
            Node nxt=t.next;
            t.next=p;
            p=t;
            t=nxt;
        }
        return p;
    }
}
  