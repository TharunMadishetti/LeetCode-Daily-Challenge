//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     static class Pair
    {
        int x,d;
        Pair(int x,int d)
        {
            this.x=x;
            this.d=d;
        }
    }
    public static List<Integer> shortestPath(int k, int m, int edges[][]) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.d-y.d);
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<k+1;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int d=edges[i][2];
            ArrayList<Integer> l=new ArrayList<>();
            l.add(v);
            l.add(d);
            adj.get(u).add(l);
            l=new ArrayList<>();
            l.add(u);
            l.add(d);
            adj.get(v).add(l);
        }
        // System.out.println(adj);
        
        int[] dist=new int[k+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        int[] src=new int[k+1];
        for(int a=0;a<=k;a++)
        src[a]=-1;
        pq.add(new Pair(1,0));
        src[1]=1;
        while(!pq.isEmpty())
        {
            int d=pq.peek().d;
            int n=pq.peek().x;
            pq.remove();
            for(ArrayList<Integer> edj:adj.get(n))
            {
                // System.out.println(edj+" "+n);
                if(d+edj.get(1)<dist[edj.get(0)])
                {
                    src[edj.get(0)]=n;
                    dist[edj.get(0)]=d+edj.get(1);
                    pq.add(new Pair(edj.get(0),dist[edj.get(0)]));
                }
            }
        }
        
        Stack<Integer> st=new Stack<>();
        int p=k;
        if(dist[k]==Integer.MAX_VALUE)
        {
            ArrayList<Integer> res=new ArrayList<>();
            res.add(-1);
            return res;
        }
        // System.out.println(Arrays.toString(src));
        while(p!=src[p])
        {
            st.push(p);
            p=src[p];
        }
        st.push(1);
        List<Integer> ans=new ArrayList<>();
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        return ans;
    }
    
}