//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair
    {
        int x;
        long d;
        Pair(int x_,long _d)
        {
            x=x_;
            d=_d;
        }
    }
    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        List<List<ArrayList<Integer>>> g=new ArrayList<>();
        for(int i=0;i<n;i++)
        g.add(new ArrayList<>());
        for(int i=0;i<roads.size();i++)
        {
            int u=roads.get(i).get(0);
            int v=roads.get(i).get(1);
            int d=roads.get(i).get(2);
            ArrayList<Integer> l=new ArrayList<>();
            l.add(u);
            l.add(d);
            g.get(v).add(l);
            l=new ArrayList<>();
            l.add(v);
            l.add(d);
            g.get(u).add(l);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.d,y.d));
        int[] w=new int[n];
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        w[0]=1;
        dist[0]=0;
        pq.add(new Pair(0,0));
        int mod=(int)(1e9+7);
        while(!pq.isEmpty())
        {
            int x=pq.peek().x;
            long d=pq.peek().d;
            pq.remove();
            for(ArrayList<Integer> edge:g.get(x))
            {
                if(edge.get(1)+d<dist[edge.get(0)])
                {
                    w[edge.get(0)]=w[x];
                    dist[edge.get(0)]=d+edge.get(1);
                    pq.add(new Pair(edge.get(0),dist[edge.get(0)]));
                }
                else if(edge.get(1)+d==dist[edge.get(0)])
                w[edge.get(0)]=(w[edge.get(0)]%mod+w[x]%mod)%mod;
                
            }
            
        }
        return w[n-1];
    }
}
